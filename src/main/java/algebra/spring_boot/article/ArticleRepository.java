package algebra.spring_boot.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {

    List<Article> findByPriceBetweenAndCategoryId( BigDecimal minPrice, BigDecimal maxPrice, Integer categoryId);

    List<Article> findByNameOrDescriptionIgnoreCase(String name, String description);
    @Query("SELECT a from Article a where a.price = (SELECT MAX(a2.price) from Article a2 WHERE a2.category = a.category)")
    List<Article> findTopExpensiveByCategory();

    @Query("SELECT COUNT(a) FROM Article a WHERE a.category.id = :categoryId")
    Integer countArticlesByCategory(@Param("categoryId") Integer categoryId);



}