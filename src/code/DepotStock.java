package code;

// Interface du dépôt de stock (à implémenter en test)
public interface DepotStock {
    int getStock(String referenceArticle);
}

// Version classe nommée — plus lisible pour les débutants
class StockToujoursDisponible implements DepotStock {
    public int getStock(String reference) { return 100; }
}
