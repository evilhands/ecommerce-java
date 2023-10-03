package work.schwarzmaier.ecommercejava.infrastructor.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import work.schwarzmaier.ecommercejava.service.product.Product;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

interface CrudRepo extends CrudRepository<Product,Long>{};

@Repository
public class ProductRepository {

    @Autowired
    private CrudRepo crudRepo;

    public List<Product> findAll(){
        return StreamSupport
                .stream( crudRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void save(Product product){
        crudRepo.save(product);
    }
    public void save(Iterable<Product> products){
        crudRepo.saveAll(products);
    }
}
