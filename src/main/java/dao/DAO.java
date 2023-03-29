package dao;

import java.util.List;
import java.util.Optional;

public abstract class DAO<T> {

    abstract Optional<T> get(long id);

    abstract List<T> getAll();

    abstract void save(T t);

    abstract void update(T t, String[] params);

    abstract void delete(T t);
}
