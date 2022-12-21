package ra.model.repository;

import ra.model.entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerRepository extends JpaRepository<Flower,Integer> {
}
