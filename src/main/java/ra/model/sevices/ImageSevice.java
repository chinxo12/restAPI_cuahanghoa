package ra.model.sevices;

import ra.model.entity.Image;

public interface ImageSevice {
    Image saveOrUpdate(Image image);
    void deleteById(int id);
}
