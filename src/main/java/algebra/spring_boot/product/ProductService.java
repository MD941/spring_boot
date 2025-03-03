package algebra.spring_boot.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public Product create(CreateProductDto dto){
        return new Product(12l, dto.getName());
    }

    public Product update(Long id, UpdateProductDto dto){
        Product productFromDb = new Product(id, "old name");

        productFromDb.setName(dto.getName());
        return productFromDb;
    }

    public Product findById (Long id){
        return new Product(id, "some name from db");
    }

    public List<Product> fetchAll(){
        return List.of(new Product(12l, "Mobitel"), new Product(15l, "Klima uredaj"));
    }

    public void delete(Long id){
        System.out.println("Product se brise iz baze podataka... Id: " + id);
        // logika za delete producta...
    }
}