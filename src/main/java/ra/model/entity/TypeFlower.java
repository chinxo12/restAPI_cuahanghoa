package ra.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "typeflower")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TypeFlower {
    @Id
    @Column(name = "typeFlowerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeFlowerId;
    @Column(name = "typeFlowerName",nullable = true)
    private String typeFlowerName;
    @Column(name = "typeFlowerTitle")
    private String typeFlowerTitle;
    @Column(name = "typeFlowerStatus")
    private boolean typeFlowerStatus;


}
