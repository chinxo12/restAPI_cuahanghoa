package ra.model.sevices;

import java.util.List;

public interface Sevices <T,E>{
    T saveAndUpdate(T t);
    List<T> findAll ();
    T findById(E id);
    void delete(E id);
}