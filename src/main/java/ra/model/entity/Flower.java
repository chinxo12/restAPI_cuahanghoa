package ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "flower")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flowerId")
    private int flowerId;
    @Column(name = "flowerName")
    private String flowerName;
    @Column(name = "importPrice")
    private float importPrice;
    @Column(name = "exportPrice")
    private float exportPrice;
    @Column(name = "flowerTitle")
    private String flowerTitle;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeFlowerId" , referencedColumnName = "typeFlowerId")
    private TypeFlower typeFlower;
    @Column(name = "flowerStatus")
    private boolean flowerStatus;
    @JsonIgnore
    @OneToMany(mappedBy = "flower",fetch = FetchType.LAZY)
    private List<FlowerProduct> listFlowerProduct  = new ArrayList<>();

}
