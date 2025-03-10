package algebra.spring_boot.article;

import algebra.spring_boot.article.dto.CreateArticleDto;
import algebra.spring_boot.article.dto.UpdateArticleDto;
import algebra.spring_boot.category.Category;
import algebra.spring_boot.category.CategoryRepository;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository,
                              CategoryRepository categoryRepository){
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Article> fetchAll(){
        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> findById(Integer id){
        return articleRepository.findById(id);
    }

    @Override
    public Article create(CreateArticleDto dto){
        Optional<Category> category = categoryRepository.findById(dto.getCategoryId());

        if (category.isEmpty()){
            throw new InternalException("Category not found");
        }

        Article article = new Article(dto.getName(), dto.getDescription(), dto.getPrice(), category.get());
        return articleRepository.save(article);
    }

    @Override
    public Article update (Integer id, UpdateArticleDto dto){
        Optional<Article> article = articleRepository.findById(id);

        if (article.isEmpty()) {
            throw new InternalException("Article not found");
        }

        Optional<Category> category = categoryRepository.findById(dto.getCategoryId());
        if (category.isEmpty()){
            throw new InternalException("Category not found");
        }

        Article articleForUpdate = article.get();
        articleForUpdate.setName(dto.getName());
        articleForUpdate.setDescription(dto.getDescription());
        articleForUpdate.setPrice(dto.getPrice());
        articleForUpdate.setCategory(category.get());

        return articleRepository.save(articleForUpdate);
    }

    public void delete(Integer id){
            Optional<Article> article = articleRepository.findById(id);
            if (article.isEmpty()){
                throw new InternalException("Category not found");
    }
        articleRepository.delete(article.get());
    }


    @Override
    public List<Article> findByMinMaxPriceAndCategoryId(BigDecimal minPrice, BigDecimal maxPrice, Integer categoryId) {
        return articleRepository.findByPriceBetweenAndCategoryId(minPrice,maxPrice,categoryId);
    }

    @Override
    public List<Article> findByNameOrDescriptionIgnoreCase(String name, String description) {
        return articleRepository.findByNameOrDescriptionIgnoreCase(name, description);
    }
}