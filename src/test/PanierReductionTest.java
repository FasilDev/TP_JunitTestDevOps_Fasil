package test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import code.Article;
import code.Panier;

class PanierReductionTest {
    @ParameterizedTest
    @CsvSource({
            " , 100.0", // pas de code de réduction
            "reduc10, 90.0", // -10%
            "reduc20, 80.0" // -20%
    })
    void calculerTotalDoitAppliquerLaBonneReduction(
            String code, double totalAttendu) {
        // Arranger
        Panier panier = new Panier();
        Article articleC = new Article("REF-001", "Classeur", 10.0);
        panier.ajouterArticle(articleC, 2); // sous-total = 20.0
        Article articleB = new Article("REF-002", "Batterie externe", 20.0);
        panier.ajouterArticle(articleB, 4); // sous-total = 80.0

        // Agir
        if (code != null && !code.isBlank()) {
            panier.appliquerCodeReduction(code.trim());
        }
        // Affirmer
        assertEquals(totalAttendu, panier.calculerTotal(), 0.001);
    }
}