package dam.jmdh.repositories;

import java.util.List;

public interface Repository <T> {
    // Metodos abstractos para operaciones CRUD
    void save( T t);
    List<T> findAll();
    T findOneById(int id);

    void update(T t);

    void delete(T t);


}
