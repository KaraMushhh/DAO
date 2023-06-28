package genereDao;

import model.Editore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EditoreDaoImpl implements EditoreDao {
    private Connection connection;

    public EditoreDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Editore> getAll() throws SQLException {
        List<Editore> editori = new ArrayList<>();
        String sql = "SELECT * FROM editore";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Editore editore = new Editore();
                editore.setId(resultSet.getInt("codiceE"));
                editore.setNome(resultSet.getString("nome"));
                editore.setSede(resultSet.getString("sede"));
                editori.add(editore);
            }
        }
        return editori;
    }

    @Override
    public Editore getEditoreById(int codiceG) throws SQLException {
        String sql = "SELECT * FROM editore WHERE codiceE = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codiceG);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Editore editore = new Editore();
                    editore.setId(resultSet.getInt("codiceE"));
                    editore.setNome(resultSet.getString("nome"));
                    editore.setSede(resultSet.getString("sede"));
                    return editore;
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public void insert(Editore editore) throws SQLException {
        String sql = "INSERT INTO editore(nome, sede) VALUES (?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, editore.getNome());
            statement.setString(2, editore.getSede());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Editore editore) throws SQLException {
        String sql = "UPDATE editore SET nome = ?, sede =? WHERE codiceE = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, editore.getNome());
            statement.setString(2, editore.getSede());
            statement.setInt(3, editore.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(int codiceG) throws SQLException {
        String sql = "DELETE FROM editore WHERE codiceE = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codiceG);
            statement.executeUpdate();
        }
    }
}