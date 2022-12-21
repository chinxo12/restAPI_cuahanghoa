package ra.model.sevicesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.FlowerProduct;
import ra.model.repository.FlowerProductRepository;
import ra.model.sevices.FlowerProductSevices;

import java.util.List;

@Service
public class FlowerProductSevicesImp implements FlowerProductSevices {
    @Autowired
    private FlowerProductRepository flowerProductRepository;
    @Override
    public FlowerProduct saveOrUpdate(FlowerProduct flowerProduct) {
        return flowerProductRepository.save(flowerProduct);
    }

    @Override
    public List<FlowerProduct> findByProductId(int id) {
        return flowerProductRepository.findByProduct_ProductId(id);
    }

    @Override
    public void deleteById(int id) {
        flowerProductRepository.deleteById(id);
    }
}
