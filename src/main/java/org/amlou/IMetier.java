package org.amlou;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IMetier<T> {
    void add(T o);

    List<T> getAll();

    T findById(long id);

    void delete(long id);

    void saveAll() throws IOException;
}
