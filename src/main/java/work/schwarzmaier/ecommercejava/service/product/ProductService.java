package work.schwarzmaier.ecommercejava.service.product;

import work.schwarzmaier.ecommercejava.service.common.interfaces.persistence.IProductRepository;

import java.util.List;

class ProductService implements IProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
