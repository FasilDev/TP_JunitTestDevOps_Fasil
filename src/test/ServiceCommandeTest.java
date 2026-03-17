package test;

import code.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ServiceCommandeTest {
    private DepotStock stockDisponible = reference -> 100;
    private ServiceCommande service;
    private Panier panier;
    private Article articleTest;

    @BeforeEach
    void initialiser() {
        service = new ServiceCommande(stockDisponible);
        panier = new Panier();
        articleTest = new Article("REF-001", "Cahier", 3.50);
    }

    @Test
    void commandeValideDoitRetournerUneCommande() {
        panier.ajouterArticle(articleTest, 2);
        Commande commande = service.passerCommande(panier, "CLIENT-42");
        assertNotNull(commande);
        assertEquals(7.0, commande.total(), 0.001);
    }

    @Test
    void panierVideDoitLeverIllegalStateException() {
        //Arranger
        //Agir & Affirmer
        assertThrows(IllegalStateException.class, () ->
            service.passerCommande(panier, "C1"));
        }

    @Test
    void identifiantClientNulDoitLeverException() {
        //Arranger
        //Agir & Affirmer
        panier.ajouterArticle(articleTest, 2);
        assertThrows(IllegalArgumentException.class, () ->
                service.passerCommande(panier, null));
    }

    @Test
    void identifiantClientVideDoitLeverException() {
        //Arranger
        //Agir & Affirmer
        panier.ajouterArticle(articleTest, 2);
        assertThrows(IllegalArgumentException.class, () ->
                service.passerCommande(panier, ""));
    }

    @Test
    void stockInsuffisantDoitLeverStockInsuffisantException() {
        //Arranger
        //Agir & Affirmer
        panier.ajouterArticle(articleTest, 105);
        assertThrows(StockInsuffisantException.class, () ->
            service.passerCommande(panier, "CLIENT-43"));
    }

    @Test
    void totalCommandeDoitCorrespondreAuTotalDuPanier()  {
        //Arranger
        //Agir
        panier.ajouterArticle(articleTest, 2);
        Commande commande = service.passerCommande(panier, "CLIENT-44");
        //Affirmer
        assertEquals(panier.calculerTotal(), commande.total(), 0.001);
    }

};

