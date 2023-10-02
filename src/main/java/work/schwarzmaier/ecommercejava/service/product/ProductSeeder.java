package work.schwarzmaier.ecommercejava.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

        List<Product> productList = new ArrayList<>();

        IntStream.range(0,100).forEach(i -> productList.add(product.copy()));
        productRepository.save(productList);
    }
}
