package work.schwarzmaier.ecommercejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
}
