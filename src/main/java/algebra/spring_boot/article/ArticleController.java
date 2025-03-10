package algebra.spring_boot.article;

import algebra.spring_boot.article.dto.CreateArticleDto;
import algebra.spring_boot.article.dto.UpdateArticleDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")

public class ArticleController {

    private final ArticleService articleService;
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleService articleService, ArticleRepository articleRepository) {
        this.articleService = articleService;
        this.articleRepository = articleRepository;
    }

    @GetMapping
    public ResponseEntity<List<Article>> fetchAll(){
        List<Article> articles = articleService.fetchAll();
        return ResponseEntity.status(200).body(articles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> findById(@PathVariable Integer id){
        Optional<Article> article = articleService.findById(id);

        if (article.isEmpty()){
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(article.get());
    }

    @PostMapping()
    public ResponseEntity<Article> create (@Valid @RequestBody CreateArticleDto dto){
        Article article = articleService.create(dto);
        return ResponseEntity.status(200).body(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> update (@Valid @RequestBody UpdateArticleDto dto, @PathVariable Integer id){
        Article article = articleService.update(id, dto);
        return ResponseEntity.status(200).body(article);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Article>> findByMinAndMaxPriceAndCategoryId(@RequestParam BigDecimal minPrice, @RequestParam BigDecimal maxPrice, @RequestParam Integer categoryId){
        List<Article> articleList = articleService.findByMinMaxPriceAndCategoryId(minPrice, maxPrice, categoryId);

        if (articleList.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(articleList.stream().toList());
    }

    @GetMapping("/findName")
    public ResponseEntity<List<Article>> findByNameOrDescription(@RequestParam String name, @RequestParam String description){
        List<Article> articleList = articleService.findByNameOrDescriptionIgnoreCase(name, description);

        if (articleList.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(articleList.stream().toList());
    }
    @GetMapping("/top-expensive")
    public ResponseEntity<List<Article>> findTopExpensiveArticle(){
        List<Article> articleList = articleRepository.findTopExpensiveByCategory();

        if (articleList.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(articleList.stream().toList());
    }
    @GetMapping("/count-articles/{id}")
    public ResponseEntity<Integer> countArticle( @PathVariable Integer id){
        Integer numberOfArticles = articleRepository.countArticlesByCategory(id);

        return ResponseEntity.status(200).body(numberOfArticles);
    }

}