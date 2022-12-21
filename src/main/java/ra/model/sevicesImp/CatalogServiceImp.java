package ra.model.sevicesImp;

import ra.model.sevices.CatalogService;
import ra.model.entity.Catalog;
import ra.model.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CatalogServiceImp implements CatalogService<Catalog,Integer> {
    @Autowired
    private CatalogRepository catalogRepository;
    @Override
    public Catalog saveAndUpdate(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    @Override
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog findById(Integer id) {
        return catalogRepository.findById(id).get();
    }

    @Override
    public void delete(Integer integer) {
        catalogRepository.deleteById(integer);
    }
}
