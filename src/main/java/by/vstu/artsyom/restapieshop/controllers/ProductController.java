package by.vstu.artsyom.restapieshop.controllers;

import by.vstu.artsyom.restapieshop.entity.Product;
import by.vstu.artsyom.restapieshop.service.ProductService;
import lombok.Data;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        Product newProduct = productService.create(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productService.getAll();
        if (!products.isEmpty()) {
            //IsEmpty - проверяет, является ли строка пустой ("") или значение null.
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getNomenclatureById(@PathVariable Long id) {
        Product product = productService.getOne(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product){
        if (productService.update(id, product) != null ){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = productService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
