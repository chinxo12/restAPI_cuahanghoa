package ra.controller;


import ra.model.entity.Flower;
import ra.model.entity.TypeFlower;
import ra.model.sevices.FlowerService;
import ra.model.sevices.TypeFlowerSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("flower")
public class FlowerController {
    @Autowired
    private FlowerService<Flower,Integer> flowerServiceImp;
    @Autowired
    private TypeFlowerSevice<TypeFlower,Integer> typeFlowerSevice;

    @GetMapping
    public List<Flower> getAll(){
        List<Flower> list = flowerServiceImp.findAll();
        return flowerServiceImp.findAll();
    }
//    public ResponseEntity<?> get(){
//        List<Flower> list = flowerServiceImp.findAll();
//        return ResponseEntity.ok(list.get(0).getTypeFlower());
//    }

    @PostMapping("/{typeFlowerId}")
    public Flower createTypeFlower(@RequestBody Flower flower,@PathVariable int typeFlowerId){
        TypeFlower typeFlower = typeFlowerSevice.findById(typeFlowerId);
        flower.setTypeFlower(typeFlower);
        return flowerServiceImp.saveAndUpdate(flower);
    }
    @PutMapping("/{flowerId}/{typeFlowerId}")
    public Flower updateTypeFlower(@RequestBody Flower flower,@PathVariable("flowerId") int flowerId,@PathVariable("typeFlowerId") int typeFlowerId){
        Flower flowerUpdate = flowerServiceImp.findById(flowerId);
        flowerUpdate.setFlowerName(flower.getFlowerName());
        flowerUpdate.setFlowerTitle(flower.getFlowerTitle());
        flowerUpdate.setFlowerStatus(flower.isFlowerStatus());
        flowerUpdate.setImportPrice(flower.getImportPrice());
        flowerUpdate.setExportPrice(flower.getExportPrice());
        TypeFlower typeFlower = typeFlowerSevice.findById(typeFlowerId);
        flowerUpdate.setTypeFlower(typeFlower);
        return flowerServiceImp.saveAndUpdate(flowerUpdate);
    }
    @GetMapping("/{flowerId}")
    public Flower getById(@PathVariable("flowerId") int flowerId){
        return flowerServiceImp.findById(flowerId);
    }
    @DeleteMapping("/{flowerId}")
    public void deleteById(@PathVariable("flowerId") int flowerId){
        flowerServiceImp.delete(flowerId);
    }
}
