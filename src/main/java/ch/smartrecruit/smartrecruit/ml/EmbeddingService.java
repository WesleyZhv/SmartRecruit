package ch.smartrecruit.smartrecruit.ml;

import ai.djl.huggingface.tokenizers.HuggingFaceTokenizer;
import ai.djl.huggingface.tokenizers.Encoding;
import ai.onnxruntime.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.nio.LongBuffer;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;

@Service
public class EmbeddingService {

    private HuggingFaceTokenizer tokenizer;
    private OrtEnvironment env;
    private OrtSession session;

    @PostConstruct
    public void init() throws Exception {
        tokenizer = HuggingFaceTokenizer.newInstance(Paths.get("models/tokenizer.json"));
        env = OrtEnvironment.getEnvironment();
        session = env.createSession("models/model.onnx", new OrtSession.SessionOptions());
    }

    public float[] embed(String texte) throws Exception {
        Encoding encoding = tokenizer.encode(texte);

        long[] ids = encoding.getIds();
        long[] attentionMask = encoding.getAttentionMask();
        long[] typeIds = encoding.getTypeIds();

        long[] shape = {1, ids.length};

        OnnxTensor inputIdsTensor = OnnxTensor.createTensor(env, LongBuffer.wrap(ids), shape);
        OnnxTensor attentionMaskTensor = OnnxTensor.createTensor(env, LongBuffer.wrap(attentionMask), shape);
        OnnxTensor tokenTypeTensor = OnnxTensor.createTensor(env, LongBuffer.wrap(typeIds), shape);

        Map<String, OnnxTensor> inputs = Map.of(
                "input_ids", inputIdsTensor,
                "attention_mask", attentionMaskTensor,
                "token_type_ids", tokenTypeTensor
        );

        OrtSession.Result result = session.run(inputs);
        float[][][] output = (float[][][]) result.get(0).getValue();

        return meanPooling(output[0], attentionMask);
    }

    private float[] meanPooling(float[][] tokenEmbeddings, long[] attentionMask) {
        int dim = tokenEmbeddings[0].length;
        float[] pooled = new float[dim];
        float maskSum = 0;

        for (int i = 0; i < tokenEmbeddings.length; i++) {
            if (attentionMask[i] == 1) {
                for (int j = 0; j < dim; j++) {
                    pooled[j] += tokenEmbeddings[i][j];
                }
                maskSum += 1;
            }
        }

        for (int j = 0; j < dim; j++) {
            pooled[j] /= maskSum;
        }

        return normalize(pooled);
    }

    private float[] normalize(float[] vector) {
        float norm = 0;
        for (float v : vector) {
            norm += v * v;
        }
        norm = (float) Math.sqrt(norm);

        float[] normalized = new float[vector.length];
        for (int i = 0; i < vector.length; i++) {
            normalized[i] = vector[i] / norm;
        }
        return normalized;
    }
}