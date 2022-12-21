package ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "image")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "imageId")
    private int imageId;
    @Column(name = "imageLink")
    private String imageLink;
    @JsonIgnore
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Product product;
}
