package genereDao;
import model.Genere;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GenereDaoImpl implements GenereDao {
    private Connection connection;

    public GenereDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Genere> getAll() throws SQLException {
        List<Genere> generi = new ArrayList<>();
        String sql = "SELECT * FROM genere";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Genere genere = new Genere();
                genere.setId(resultSet.getInt("codiceG"));
                genere.setNome(resultSet.getString("descrizione"));
                generi.add(genere);
            }
        }
        return generi;
    }

    @Override
    public Genere getGenereById(int id) throws SQLException {
        String sql = "SELECT * FROM genere WHERE codiceG = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Genere genere = new Genere();
                    genere.setId(resultSet.getInt("codiceG"));
                    genere.setNome(resultSet.getString("descrizione"));
                    return genere;
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public void insert(Genere genere) throws SQLException {
        String sql = "INSERT INTO genere(descrizione) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, genere.getNome());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Genere genere) throws SQLException {
        String sql = "UPDATE genere SET descrizione = ? WHERE codiceG = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, genere.getNome());
            statement.setInt(2, genere.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM genere WHERE codiceG = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}