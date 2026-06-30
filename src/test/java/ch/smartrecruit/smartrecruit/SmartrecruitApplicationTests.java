package ch.smartrecruit.smartrecruit;

import ch.smartrecruit.smartrecruit.ml.EmbeddingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ch.smartrecruit.smartrecruit.ml.SimilariteCalculateur;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	@Test
	void similariteEntrePhrasesProches() throws Exception {
		float[] vecteur1 = embeddingService.embed("Développeur Java Spring Boot");
		float[] vecteur2 = embeddingService.embed("Ingénieur logiciel Java backend");
		float[] vecteur3 = embeddingService.embed("Chef cuisinier restaurant gastronomique");

		double similariteProche = SimilariteCalculateur.similariteCosinus(vecteur1, vecteur2);
		double similariteLointaine = SimilariteCalculateur.similariteCosinus(vecteur1, vecteur3);

		System.out.println("Similarité proche (dev Java vs ingénieur Java) : " + similariteProche);
		System.out.println("Similarité lointaine (dev Java vs cuisinier) : " + similariteLointaine);

		assertTrue(similariteProche > similariteLointaine);
	}
}
