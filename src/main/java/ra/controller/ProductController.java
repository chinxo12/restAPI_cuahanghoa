package ra.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.model.DTO.FlowerProductDisplay;
import ra.model.entity.*;
import ra.model.DTO.ProductImage;
import ra.model.pojos.FlowerRequest;
import ra.model.pojos.ProductDetailRequest;
import ra.model.pojos.ProductRequest;
import ra.model.sevices.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService<Product,Integer> productService;
    @Autowired
    private CatalogService<Catalog,Integer> catalogService;
    @Autowired
    private ImageSevice imageSevice;
    @Autowired
    private FlowerService<Flower,Integer> flowerService;
    @Autowired
    private FlowerProductSevices flowerProductSevices;
    @GetMapping
    public List<ProductImage> getAll(){
        List<ProductImage> listProductImage = new ArrayList<>();
        List<Product> listProduct = productService.findAll();
        for (Product pro :listProduct) {
            ProductImage productImage = new ProductImage();
            productImage.setProductId(pro.getProductId());
            productImage.setProductName(pro.getProductName());
                productImage.setProductDiscription(pro.getProductDiscription());
            productImage.setExportPriceProduct(pro.getExportPriceProduct());
            productImage.setCatalog(pro.getCatalog());
            productImage.getListImage().addAll(pro.getListImage());
            List<FlowerProduct> listFlower = flowerProductSevices.findByProductId(pro.getProductId());
            pro.getListFlower().addAll(listFlower);
            for (FlowerProduct flowerProduct :pro.getListFlower()) {
                FlowerProductDisplay flowerProductDisplay = new FlowerProductDisplay();
                flowerProductDisplay.setFlower(flowerProduct.getFlower());
                flowerProductDisplay.setQuantity(flowerProduct.getQuantity());
                productImage.getListFlowerProduct().add(flowerProductDisplay);
            }
            listProductImage.add(productImage);
        }
        return listProductImage;
    }
    @PostMapping("add")
    public ProductImage addProduct(@RequestBody ProductRequest productRequest){
        Product pro = new Product();
        pro.setProductName(productRequest.getProductName());
        pro.setExportPriceProduct(productRequest.getCatalogId());
        pro.setProductDiscription(productRequest.getProductDiscription());
        Catalog catalog = catalogService.findById(productRequest.getCatalogId());
        pro.setCatalog(catalog);
        pro = productService.saveAndUpdate(pro);
        for (String str :productRequest.getListImage()) {
            Image image = new Image();
            image.setProduct(pro);
            image.setImageLink(str);
            image = imageSevice.saveOrUpdate(image);
            pro.getListImage().add(image);
        }

        ProductImage productImage = new ProductImage();
        productImage.setProductId(pro.getProductId());
        productImage.setProductName(pro.getProductName());
        productImage.setProductDiscription(pro.getProductDiscription());
        productImage.setExportPriceProduct(pro.getExportPriceProduct());
        productImage.setCatalog(pro.getCatalog());
        productImage.getListImage().addAll(pro.getListImage());
        return productImage;
    }
    @GetMapping("test/{productId}")
    public List<FlowerProductDisplay> testString(@PathVariable("productId") int productId){
        List<FlowerProductDisplay> flowerProductDisplayList = new ArrayList<>();
        List<FlowerProduct> list = flowerProductSevices.findByProductId(productId);
        for (FlowerProduct flowerProduct :list) {
            FlowerProductDisplay flowerProductDisplay = new FlowerProductDisplay();
            flowerProductDisplay.setFlower(flowerProduct.getFlower());
            flowerProductDisplay.setQuantity(flowerProduct.getQuantity());
            flowerProductDisplayList.add(flowerProductDisplay);
        }
        return flowerProductDisplayList;

    }
    @GetMapping("{productId}")
    public ResponseEntity<?> getProductById(@PathVariable("productId") int productId){
        ProductImage productImage = new ProductImage();
        Product pro = productService.findById(productId);
        productImage.setProductId(pro.getProductId());
        productImage.setProductName(pro.getProductName());
        productImage.setProductDiscription(pro.getProductDiscription());
        productImage.setExportPriceProduct(pro.getExportPriceProduct());
        productImage.setCatalog(pro.getCatalog());
        productImage.getListImage().addAll(pro.getListImage());
        List<FlowerProductDisplay> flowerProductDisplayList = new ArrayList<>();
        List<FlowerProduct> list = flowerProductSevices.findByProductId(productId);
        for (FlowerProduct flowerProduct :list) {
            FlowerProductDisplay flowerProductDisplay = new FlowerProductDisplay();
            flowerProductDisplay.setFlower(flowerProduct.getFlower());
            flowerProductDisplay.setQuantity(flowerProduct.getQuantity());
            flowerProductDisplayList.add(flowerProductDisplay);
        }
        productImage.getListFlowerProduct().addAll(flowerProductDisplayList);
        return ResponseEntity.ok(productImage);

    }
    @PostMapping("addProductDetail")
    public ResponseEntity<?> addProductDetail(@RequestBody ProductDetailRequest productDetailRequest){
        ProductImage productImage = new ProductImage();
        Product pro = productService.findById(productDetailRequest.getProductId());
        for (FlowerRequest flowerRequest :productDetailRequest.getListFlower()) {
            FlowerProduct flowerProduct = new FlowerProduct();
            Flower flower = flowerService.findById(flowerRequest.getFlowerId());
            flowerProduct.setFlower(flower);
            flowerProduct.setProduct(pro);
            flowerProduct.setQuantity(flowerRequest.getQuantity());
            flowerProduct = flowerProductSevices.saveOrUpdate(flowerProduct);
            FlowerProductDisplay flowerProductDisplay = new FlowerProductDisplay();
            flowerProductDisplay.setFlower(flowerProduct.getFlower());
            flowerProductDisplay.setQuantity(flowerProduct.getQuantity());
            productImage.getListFlowerProduct().add(flowerProductDisplay);
        }
        productImage.setProductId(pro.getProductId());
        productImage.setProductName(pro.getProductName());
        productImage.setProductDiscription(pro.getProductDiscription());
        productImage.setExportPriceProduct(pro.getExportPriceProduct());
        productImage.setCatalog(pro.getCatalog());
        productImage.getListImage().addAll(pro.getListImage());

        return ResponseEntity.ok(productImage);

    }
    @DeleteMapping({"/{productId}"})
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") int productId){

      try {
          List<FlowerProduct> listFlower = flowerProductSevices.findByProductId(productId);
          for (FlowerProduct flowerProduct :listFlower) {
              flowerProductSevices.deleteById(flowerProduct.getFlowerProductId());
          }
          Product product = productService.findById(productId);
          for (Image image :product.getListImage()) {
              imageSevice.deleteById(image.getImageId());
          }
          productService.delete(productId);
          return ResponseEntity.ok("ok");
      }catch (Exception e){
          return ResponseEntity.ok("k oce");
      }
    }
    
    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable("productId") int productId,@RequestBody ProductRequest productRequest){
       try {
           Product productUpdate = productService.findById(productId);
           productUpdate.setProductName(productRequest.getProductName());
           productUpdate.setProductDiscription(productRequest.getProductDiscription());
           productUpdate.setExportPriceProduct(productRequest.getExportPriceProduct());
           Catalog catalog = catalogService.findById(productRequest.getCatalogId());
           productUpdate.setCatalog(catalog);
           for (Image image :productUpdate.getListImage()) {
               imageSevice.deleteById(image.getImageId());
           }
           for (String str :productRequest.getListImage()) {
               Image image = new Image();
               image.setProduct(productUpdate);
               image.setImageLink(str);
               image = imageSevice.saveOrUpdate(image);
               productUpdate.getListImage().add(image);
           }
           return ResponseEntity.ok("oce");
       }catch (Exception e){
           e.printStackTrace();
           return ResponseEntity.ok("khum oce");
       }
    }
    @PutMapping("updateProductDetail/{productId}")
    public ResponseEntity<?> updateProductDetail(@RequestBody ProductDetailRequest productDetailRequest,@PathVariable("productId") int productId){
        try {
            Product pro = productService.findById(productId);
            for (FlowerRequest flowerRequest :productDetailRequest.getListFlower()) {
                FlowerProduct flowerProduct = new FlowerProduct();
                Flower flower = flowerService.findById(flowerRequest.getFlowerId());
                flowerProduct.setFlower(flower);
                flowerProduct.setProduct(pro);
                flowerProduct.setQuantity(flowerRequest.getQuantity());
                flowerProductSevices.saveOrUpdate(flowerProduct);
            }
            return ResponseEntity.ok("oce");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok("khum oce");
        }
    }
}
