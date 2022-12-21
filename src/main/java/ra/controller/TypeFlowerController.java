package ra.controller;

import ra.model.entity.TypeFlower;
import ra.model.sevices.TypeFlowerSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("typeFlower")
public class TypeFlowerController {
    @Autowired
    private TypeFlowerSevice<TypeFlower,Integer> typeFlowerServiceImp;


    @GetMapping
    public List<TypeFlower> getAll(){
        return typeFlowerServiceImp.findAll();
    }


    @PostMapping
    public TypeFlower createTypeFlower(@RequestBody TypeFlower typeFlower){
        return typeFlowerServiceImp.saveAndUpdate(typeFlower);
    }

    @PutMapping("/{typeFlowerId}")
    public TypeFlower updateTypeFlower(@RequestBody TypeFlower typeFlower,@PathVariable("typeFlowerId") int typeFlowerId){
        TypeFlower typeFlowerUpdate = typeFlowerServiceImp.findById(typeFlowerId);
        typeFlowerUpdate.setTypeFlowerName(typeFlower.getTypeFlowerName());
        typeFlowerUpdate.setTypeFlowerTitle(typeFlower.getTypeFlowerTitle());
        typeFlowerUpdate.setTypeFlowerStatus(typeFlower.isTypeFlowerStatus());
        return typeFlowerServiceImp.saveAndUpdate(typeFlowerUpdate);
    }
    @GetMapping("/{typeFlowerId}")
    public TypeFlower getById(@PathVariable("typeFlowerId") int typeFlowerId){
        return typeFlowerServiceImp.findById(typeFlowerId);
    }
    @DeleteMapping("/{typeFlowerId}")
    public void deleteById(@PathVariable("typeFlowerId") int typeFlowerId){
         typeFlowerServiceImp.delete(typeFlowerId);
    }

}
