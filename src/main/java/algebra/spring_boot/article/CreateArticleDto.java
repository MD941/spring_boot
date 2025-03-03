package algebra.spring_boot.article;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CreateArticleDto {

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer categoryId;
}
