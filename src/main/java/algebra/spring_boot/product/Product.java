package algebra.spring_boot.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Product {

    private final Long id;

    private String name;



    // @AllArgsConstructor
    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // @RequiredArgsConstructor
    public Product(Long id) {
        this.id = id;
    }
}