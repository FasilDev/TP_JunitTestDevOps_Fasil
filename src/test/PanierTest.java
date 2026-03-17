package test;

import code.Article;
import code.Panier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PanierTest {
    @Test
    void ajouterArticleDeitAugmenterLeNombreDeArticles() {
        // Arranger
        Panier panier = new Panier();
        Article article = new Article("REF-001", "Stylo bleu", 1.50);
        //
        // Agir
        panier.ajouterArticle(article, 2);
        // Affirmer
        assertEquals(1, panier.nombreArticles());
    }

    @Test
    void calculerTotalDoitRetournerLaSommeDessousTotaux() {
        //Arranger
        Panier panier = new Panier();
        Article article = new Article("REF-001", "Stylo bleu", 1.50);
        Article article2 = new Article("REF-002", "Stylo vert", 1.50);
        //
        //Agir
        panier.ajouterArticle(article, 3);
        panier.ajouterArticle(article2, 3);
        //Affirmer
        assertEquals(9, panier.calculerTotal());
    }

    @Test
    void panierVideDoitRetournerEstVideEgalTrue() {
        //Arranger
        Panier panier = new Panier();
        Article article = new Article("REF-001", "Stylo1", 1.50);
        Article article2 = new Article("REF-002", "Stylo2", 2.50);
        //
        //Agir
        //Affirmer
        assertTrue(panier.estVide());
    }

    @Test
    void panierAvecArticlesNeDoitPasEtreVide() {
        //Arranger
        Panier panier = new Panier();
        Article article = new Article("REF-001", "Stylo1", 1.50);
        Article article2 = new Article("REF-002", "Stylo2", 2.50);
        //
        //Agir
        panier.ajouterArticle(article, 3);
        panier.ajouterArticle(article2, 4);
        //Affirmer
        assertFalse(panier.estVide());
    }

    @Test
    void quantiteNulleDoitLeverUneException() {
        Panier panier = new Panier();
        Article article = new Article("REF-001", "Stylo", 1.50);
        assertThrows(IllegalArgumentException.class, () ->
                panier.ajouterArticle(article, 0)
        );
    }

    @Test
    void articleNulDoitLeverUneException() {
        //Arranger
        Panier panier = new Panier();
        Article article = new Article("REF-001", "Stylo", 1.50);
        //Agir & Affirmer
        assertThrows(IllegalArgumentException.class, () ->
                panier.ajouterArticle(null, 1)
        );
    }

    @Test
    void quantiteNegativeDoitLeverUneException() {
        //Arranger
        Panier panier = new Panier();
        Article article = new Article("REF-001", "Stylo", 1.50);
        //Agir & Affirmer
        assertThrows(IllegalArgumentException.class, () ->
                panier.ajouterArticle(article, -3)
        );
    }

    @Test
    void codeReductionVideDoitLeverException() {
        //Arranger
        Panier panier = new Panier();
        Article article = new Article("REF-001", "Stylo", 1.50);
        //Agir & Affirmer
        assertThrows(IllegalArgumentException.class, () ->
                panier.appliquerCodeReduction("")
        );
    }

    @Test
    void codeReductionNulDoitLeverException() {
        //Arranger
        Panier panier = new Panier();
        Article article = new Article("REF-001", "Stylo", 1.50);
        //Agir & Affirmer
        assertThrows(IllegalArgumentException.class, () ->
                panier.appliquerCodeReduction(null)
        );
    }

    @Test
    void articleGratuitDoitEtreAccepte() {
        //Arranger
        Panier panier = new Panier();
        Article articleGratuit = new Article("OFFERT-01", "Stylo offert", 0.0);
        //Agir
        panier.ajouterArticle(articleGratuit, 1);
        //Affirmer
        assertEquals(0.0, panier.calculerTotal(), 0.001);
    }

    @Test
    void quantiteUneDoitEtreAcceptee() {
        //Arranger
        Panier panier = new Panier();
        Article articleL = new Article("REF-037", "Lampe LED bureau", 9.99);
        //Agir
        panier.ajouterArticle(articleL, 1);
        //Affirmer
        assertEquals(9.99, panier.calculerTotal(), 0.001);
    }

    @Test
    void prixEleveDoitFonctionner() {
        //Arranger
        Panier panier = new Panier();
        Article articleT = new Article("REF-E46", "TV OLED 4K", 999.99);
        //Agir
        panier.ajouterArticle(articleT, 1);
        //Affirmer
        assertEquals(999.99, panier.calculerTotal(), 0.001);
    }

    @Test
    void panierAvecUnSeulArticleDoitFonctionner() {
        //Arranger
        Panier panier = new Panier();
        Article articleT = new Article("REF-E46", "TV OLED 4K", 999.99);
        //Agir
        panier.ajouterArticle(articleT, 1);
        //Affirmer
        assertEquals(999.99, panier.calculerTotal(), 0.001);
    }

    @Test
    void plusieursArticlesDifferentsDansPanier() {
        //Arranger
        Panier panier = new Panier();
        Article article = new Article("REF-001", "Stylo", 1.50);
        Article articleL = new Article("REF-037", "Lampe LED bureau", 9.99);
        Article articleT = new Article("REF-E46", "TV OLED 4K", 999.99);
        //Agir
        panier.ajouterArticle(article, 1);
        panier.ajouterArticle(articleT, 1);
        panier.ajouterArticle(articleL, 1);
        //Affirmer
        assertEquals(1011.48, panier.calculerTotal(), 0.001);
    }
}