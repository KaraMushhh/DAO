package genereDao;

import model.Autore;
import java.util.List;
import java.sql.SQLException;

public interface AutoreDao {
    List<Autore> getAll() throws SQLException;
    Autore getAutoreById(int codiceA) throws SQLException;
    void insert(Autore editore) throws SQLException;
    void update(Autore editore) throws SQLException;
    void delete(int codiceA) throws SQLException;
}
