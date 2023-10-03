package work.schwarzmaier.ecommercejava.api.product;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.schwarzmaier.ecommercejava.service.common.interfaces.persistence.IProductRepository;
import work.schwarzmaier.ecommercejava.service.product.Product;

import java.util.List;

@RestController
@RequestMapping("/products")
class ProductController {

    private final IProductRepository productRepository;

    public ProductController(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }
}
