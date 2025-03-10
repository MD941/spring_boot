package algebra.spring_boot.article;

import algebra.spring_boot.category.Category;
import algebra.spring_boot.category.CategoryRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Article(Integer id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Article(String name, String description, BigDecimal price, Category category){
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
}