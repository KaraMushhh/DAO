package genereDao;
import model.Genere;
import java.util.List;
import java.sql.SQLException;

public interface GenereDao {
    List<Genere> getAll() throws SQLException;
    Genere getGenereById(int id) throws SQLException;
    void insert(Genere genere) throws SQLException;
    void update(Genere genere) throws SQLException;
    void delete(int id) throws SQLException;
}