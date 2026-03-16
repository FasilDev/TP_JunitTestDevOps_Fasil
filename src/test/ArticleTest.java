package test;
import code.Article;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArticleTest {

    @Test
    void creerArticleValideDoitFonctionner() {
        // Arranger & Agir
        Article article = new Article("REF-001", "Cahier", 3.50);
        // Affirmer
        assertEquals("REF-001", article.getReference());
        assertEquals("Cahier", article.getNom());
        assertEquals(3.50, article.getPrix(), 0.001);

    }

    @Test
    void modifierPrixDoitMettreAJourLePrix() {
        //Arranger
        Article article = new Article("REF-002", "Règle", 1.00);
        //Agir
        article.setPrix(1.50);
        //Affirmer
        assertEquals(1.50, article.getPrix(), 0.001);
    }

    @Test
    void referenceNulleDoitLeverException() {
        //Arranger
        //Agir & Affirmer
        assertThrows(IllegalArgumentException.class, () -> {
            Article article = new Article(null, "Règle", 1.0);
        });
    }

    @Test
    void nomVideDoitLeverException() {
        //Arranger
        //Agir & Affirmer
        assertThrows(IllegalArgumentException.class, () -> {
            Article article = new Article("REF-001", "", 1.0);
        });
    }

    @Test
    void prixNegatifAlaCreationDoitLeverException() {
        //Arranger
        //Agir & Affirmer
        assertThrows(IllegalArgumentException.class, () -> {
            Article article = new Article("REF-001", "X", -1.0);
        });
    }

    @Test
    void setPrixNegatifDoitLeverException() {
        //Arranger
        Article article = new Article("REF-001", "X", 2.0);
        //Agir & Affirmer
        assertThrows(IllegalArgumentException.class, () -> {
            article.setPrix(-5.0);
        });
    }
}