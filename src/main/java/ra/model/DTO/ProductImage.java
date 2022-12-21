package ra.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ra.model.DTO.FlowerProductDisplay;
import ra.model.entity.Catalog;
import ra.model.entity.Image;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {
    private int productId;
    private String productName;
    private float exportPriceProduct;
    private String productDiscription;
    private Catalog catalog;
    private List<Image> listImage = new ArrayList<>();
    private List<FlowerProductDisplay> listFlowerProduct = new ArrayList<>();
}
