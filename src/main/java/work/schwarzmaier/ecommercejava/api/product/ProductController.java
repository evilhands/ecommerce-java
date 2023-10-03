package work.schwarzmaier.ecommercejava.api.product;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.schwarzmaier.ecommercejava.infrastructor.persistence.ProductRepository;
import work.schwarzmaier.ecommercejava.service.product.Product;

import java.util.List;

@RestController
@RequestMapping("/products")
class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
