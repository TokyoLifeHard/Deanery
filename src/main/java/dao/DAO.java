package dao;

import java.util.List;
import java.util.Optional;

public abstract class DAO<T> {

    public abstract Optional<T> get(long id);

    public abstract List<T> getAll();

    public abstract void save(T t);

    public abstract void update(T t, T t1);

    public abstract void delete(T t);
}
