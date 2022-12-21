package ra.model.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ra.model.entity.Catalog;
import ra.model.entity.Image;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private int productId;
    private String productName;
    private float exportPriceProduct;
    private String productDiscription;
    private int catalogId;
    private List<String> listImage = new ArrayList<>();

}
