package ra.model.sevicesImp;

import ra.model.sevices.FlowerService;
import ra.model.entity.Flower;
import ra.model.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlowerServiceImp implements FlowerService<Flower,Integer> {
    @Autowired
    private FlowerRepository flowerRepository;
    @Override
    public Flower saveAndUpdate(Flower flower) {
        return flowerRepository.save(flower);
    }

    @Override
    public List<Flower> findAll() {
        return flowerRepository.findAll();
    }

    @Override
    public Flower findById(Integer id) {
        return flowerRepository.findById(id).get();
    }

    @Override
    public void delete(Integer integer) {
        flowerRepository.deleteById(integer);
    }
}
