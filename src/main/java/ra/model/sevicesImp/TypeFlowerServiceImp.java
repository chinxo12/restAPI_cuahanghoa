package ra.model.sevicesImp;

import ra.model.entity.TypeFlower;
import ra.model.repository.TypeFlowerRepository;
import ra.model.sevices.TypeFlowerSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeFlowerServiceImp implements TypeFlowerSevice<TypeFlower,Integer> {
    @Autowired
    private TypeFlowerRepository typeFlowerRepository;
    @Override
    public TypeFlower saveAndUpdate(TypeFlower typeFlower) {
        return typeFlowerRepository.save(typeFlower);
    }

    @Override
    public List<TypeFlower> findAll() {
        return typeFlowerRepository.findAll();
    }

    @Override
    public TypeFlower findById(Integer id) {
        return typeFlowerRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        typeFlowerRepository.deleteById(id);
    }
}
