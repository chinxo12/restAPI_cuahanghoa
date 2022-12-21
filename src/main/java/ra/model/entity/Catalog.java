package ra.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "catalog")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalogId")
    private int catalogId;
    @Column(name = "catalogName")
    private String catalogName;
    @Column(name = "parentId")
    private int parentId;
    @Column(name = "catalogStatus")
    private boolean catalogStatus;
}
