import java.time.LocalDateTime;

// Interface du dépôt de stock (à implémenter en test)
public interface DepotStock {
    int getStock(String referenceArticle);
}
