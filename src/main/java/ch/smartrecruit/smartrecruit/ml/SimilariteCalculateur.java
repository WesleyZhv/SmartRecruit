package ch.smartrecruit.smartrecruit.ml;

public class SimilariteCalculateur {

    public static double similariteCosinus(float[] vecteurA, float[] vecteurB) {
        double produitScalaire = 0;
        for (int i = 0; i < vecteurA.length; i++) {
            produitScalaire += vecteurA[i] * vecteurB[i];
        }
        return produitScalaire;
    }
}