package work.schwarzmaier.ecommercejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Product product = new Product();
        product.setDescription("Desc");
        product.setName("Name");
        product.setImagePath("path");
        product.setPrice(BigDecimal.valueOf(1));

        productRepository.save(product);
    }
}
