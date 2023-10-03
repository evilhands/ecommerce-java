package work.schwarzmaier.ecommercejava.service.common.interfaces.persistence;

import work.schwarzmaier.ecommercejava.service.product.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();
}