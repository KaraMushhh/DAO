package genereDao;

import model.Editore;
import java.util.List;
import java.sql.SQLException;

public interface EditoreDao {
    List<Editore> getAll() throws SQLException;
    Editore getEditoreById(int codiceG) throws SQLException;
    void insert(Editore editore) throws SQLException;
    void update(Editore editore) throws SQLException;
    void delete(int codiceG) throws SQLException;
}
