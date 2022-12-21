package ra.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ra.model.entity.Flower;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlowerProductDisplay {
    private Flower flower;
    private int quantity;
}
