package ra.controller;

import ra.model.entity.Catalog;
import ra.model.sevices.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("catalog")
public class CatalogController {
    @Autowired
    private CatalogService<Catalog,Integer> catalogService;

    @GetMapping
    public List<Catalog> getAll(){
        return catalogService.findAll();
    }


    @PostMapping
    public Catalog createTypeFlower(@RequestBody Catalog catalog){
        return catalogService.saveAndUpdate(catalog);
    }

    @PutMapping("/{catalogId}")
    public Catalog updateTypeFlower(@RequestBody Catalog catalog,@PathVariable("catalogId") int catalogId){
        Catalog catalogUpdate = catalogService.findById(catalogId);
        catalogUpdate.setCatalogName(catalog.getCatalogName());
        catalogUpdate.setParentId(catalog.getParentId());
        catalogUpdate.setCatalogStatus(catalog.isCatalogStatus());
        return catalogService.saveAndUpdate(catalogUpdate);
    }
    @GetMapping("/{catalogId}")
    public Catalog getById(@PathVariable("catalogId") int catalogId){
        return catalogService.findById(catalogId);
    }
    @DeleteMapping("/{catalogId}")
    public void deleteById(@PathVariable("catalogId") int catalogId){
        catalogService.delete(catalogId);
    }

}
