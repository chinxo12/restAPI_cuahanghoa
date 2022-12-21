package ra.model.repository;

import org.springframework.stereotype.Repository;
import ra.model.entity.TypeFlower;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TypeFlowerRepository extends JpaRepository<TypeFlower,Integer> {
}
