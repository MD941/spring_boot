package algebra.spring_boot.product;


import algebra.spring_boot.product.dto.CreateProductDto;
import algebra.spring_boot.product.dto.UpdateProductDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> fetchAll(){
        List<Product> products= productService.fetchAll();
        return ResponseEntity.ok(products);
    }

    @PostMapping()
    public ResponseEntity<Product> create(@Valid @RequestBody CreateProductDto dto){
        Product product = productService.create(dto);
        return ResponseEntity.status(201).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@Valid @RequestBody UpdateProductDto dto, @PathVariable Long id){
        Product product = productService.update(id, dto);
        return ResponseEntity.status(200).body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.status(204).build();
    }
}