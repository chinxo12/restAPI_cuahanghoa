package ra.model.sevices;


import ra.model.entity.FlowerProduct;

import java.util.List;

public interface FlowerProductSevices {
    FlowerProduct saveOrUpdate(FlowerProduct flowerProduct);
    List<FlowerProduct> findByProductId(int id);
    void deleteById(int id);
}
