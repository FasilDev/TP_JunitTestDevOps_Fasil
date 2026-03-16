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
}