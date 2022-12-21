package ra.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import ra.model.entity.Image;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private int productId;
    @Column(name = "productName")
    private String productName;
    @Column(name = "exportPriceProduct")
    private float exportPriceProduct;
    @Column(name = "productDiscription")
    private String productDiscription;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "catalogId")
    private Catalog catalog;
    @OneToMany(mappedBy = "product")
    List<Image> listImage = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER)
    List<FlowerProduct> listFlower = new ArrayList<>();

}
