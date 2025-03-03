package algebra.spring_boot.product;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
public class CreateProductDto {

    @NotBlank
    @Size(min = 3, max = 13)
    private String name;

    @Max(value = 2025)
    @Min(1500)
    private Double yearPublished;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 2)
    private List<Integer> grades;
}