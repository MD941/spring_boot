package algebra.spring_boot;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {


    private Integer id;

    @Size(min = 7)
    private String title;
    @NotNull
    private String author;
    @Size(min = 1500, max = 2025)
    private Integer yearPublished;
    @Positive
    private Integer price;

}
