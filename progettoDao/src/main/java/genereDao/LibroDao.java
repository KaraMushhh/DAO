package genereDao;

import model.Libro;
import java.util.List;
import java.sql.SQLException;

public interface LibroDao {
    List<Libro> getAll() throws SQLException;
    Libro getLibroById(int codiceL) throws SQLException;
    void insert(Libro libro) throws SQLException;
    void update(Libro libro) throws SQLException;
    void delete(int codiceL) throws SQLException;
}
