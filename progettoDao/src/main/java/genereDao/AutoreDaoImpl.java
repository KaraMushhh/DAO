package genereDao;


import model.Autore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AutoreDaoImpl implements AutoreDao {
    private Connection connection;

    public AutoreDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Autore> getAll() throws SQLException {
        List<Autore> autori = new ArrayList<>();
        String sql = "SELECT * FROM autori";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Autore autore = new Autore();
                autore.setId(resultSet.getInt("codiceA"));
                autore.setNome(resultSet.getString("nomeA"));
                autore.setSesso(resultSet.getString("sesso"));
                autore.setNazione(resultSet.getString("nazione"));
                autori.add(autore);
            }
        }
        return autori;
    }

    @Override
    public Autore getAutoreById(int codiceA) throws SQLException {
        String sql = "SELECT * FROM autori WHERE codiceA = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codiceA);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Autore autore = new Autore();
                    autore.setId(resultSet.getInt("codiceA"));
                    autore.setNome(resultSet.getString("nomeA"));
                    autore.setSesso(resultSet.getString("sesso"));
                    autore.setNazione(resultSet.getString("nazione"));
                    return autore;
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public void insert(Autore autore) throws SQLException {
        String sql = "INSERT INTO autori(nomeA, sesso, nazione) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, autore.getNome());
            statement.setString(2, autore.getNazione());
            statement.setString(3, autore.getSesso());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Autore autore) throws SQLException {
        String sql = "UPDATE autori SET nomeA = ?, sesso =?, nazione =?  WHERE codiceA = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
        	statement.setInt(4, autore.getId());
        	statement.setString(1, autore.getNome());
            statement.setString(2, autore.getSesso());
            statement.setString(3, autore.getNazione());
            
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(int codiceA) throws SQLException {
        String sql = "DELETE FROM autori WHERE codiceA = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codiceA);
            statement.executeUpdate();
        }
    }
}
