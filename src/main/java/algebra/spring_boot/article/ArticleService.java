package algebra.spring_boot.article;

import algebra.spring_boot.article.dto.CreateArticleDto;
import algebra.spring_boot.article.dto.UpdateArticleDto;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    List<Article> fetchAll();

    Optional<Article> findById(Integer id);

    Article create(CreateArticleDto dto);

    Article update (Integer id, UpdateArticleDto dto);
}