package genereDao;

import model.Editore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Autore;
import model.Libro;
import model.Genere;

public class LibroDaoImpl implements LibroDao {
    private Connection connection;

    public LibroDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Libro> getAll() throws SQLException {
        List<Libro> libri = new ArrayList<>();
        String sql = "SELECT * FROM libri";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Libro libro = new Libro();
                libro.setId(resultSet.getInt("codiceL"));
                libro.setTitolo(resultSet.getString("titolo"));
                libro.setNumPag(resultSet.getInt("numPag"));                  
                
                libri.add(libro);
            }
        }
        return libri;
    }

    @Override
    public Libro getLibroById(int codiceL) throws SQLException {
        String sql = "SELECT * FROM libri WHERE codiceL = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codiceL);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Libro libro = new Libro();
                    libro.setId(resultSet.getInt("codiceL"));
                    libro.setTitolo(resultSet.getString("titolo"));
                    libro.setNumPag(resultSet.getInt("numPag"));
                    return libro;
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public void insert(Libro libro) throws SQLException {
        String sql = "INSERT INTO libri(titolo, numPag) VALUES (?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, libro.getTitolo());
            statement.setInt(2, libro.getnumPag());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Libro libro) throws SQLException {
        String sql = "UPDATE libri SET titolo = ?, numPag =? WHERE codiceL = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, libro.getTitolo());
            statement.setInt(2, libro.getnumPag());
            statement.setInt(3, libro.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(int codiceL) throws SQLException {
        String sql = "DELETE FROM libri WHERE codiceL = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codiceL);
            statement.executeUpdate();
        }
    }
}
