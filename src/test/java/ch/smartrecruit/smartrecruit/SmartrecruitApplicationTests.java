package ch.smartrecruit.smartrecruit;

import ch.smartrecruit.smartrecruit.ml.EmbeddingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SmartrecruitApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private EmbeddingService embeddingService;

	@Test
	void embeddingALaBonneTaille() throws Exception {
		float[] vecteur = embeddingService.embed("Java développeur");
		assertEquals(384, vecteur.length);
	}

}
