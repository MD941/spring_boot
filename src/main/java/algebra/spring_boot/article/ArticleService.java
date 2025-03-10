package algebra.spring_boot.article;

import algebra.spring_boot.article.dto.CreateArticleDto;
import algebra.spring_boot.article.dto.UpdateArticleDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ArticleService {

    List<Article> fetchAll();

    Optional<Article> findById(Integer id);

    Article create(CreateArticleDto dto);

    Article update (Integer id, UpdateArticleDto dto);

    List<Article> findByMinMaxPriceAndCategoryId(BigDecimal minPrice, BigDecimal maxPrice, Integer categoryId);
    List<Article> findByNameOrDescriptionIgnoreCase(String name, String description);


}