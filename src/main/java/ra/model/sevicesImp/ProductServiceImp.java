package ra.model.sevicesImp;

import ra.model.entity.Product;
import ra.model.repository.ProductRepository;
import ra.model.sevices.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImp implements ProductService<Product,Integer> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveAndUpdate(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
