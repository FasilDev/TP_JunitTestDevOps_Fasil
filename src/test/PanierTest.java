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
        Article article2 = new Article("REF-002", "Stylo rouge", 1.70);
        //
        // Agir
        panier.ajouterArticle(article, 2);
        panier.ajouterArticle(article2, 2);
        // Affirmer
        assertEquals(1, panier.nombreArticles());
    }
}