package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ra.model.entity.FlowerProduct;

import java.util.List;
@Repository
public interface FlowerProductRepository extends JpaRepository<FlowerProduct,Integer> {
    List<FlowerProduct> findByProduct_ProductId(int id);
}
