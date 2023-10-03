package work.schwarzmaier.ecommercejava.infrastructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import work.schwarzmaier.ecommercejava.infrastructor.persistence.ProductRepository;
import work.schwarzmaier.ecommercejava.service.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
class ProductSeeder implements CommandLineRunner {

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
