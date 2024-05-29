package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_connection {
    private static final String URL = "jdbc:mysql://localhost:3306/testebd";
    private static final String USER = "root";
    private static final String PASSWORD = "54678";

    Connection connection = null;

    public static Connection getConnection() throws SQLException {
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);

        }catch(SQLException e){
            throw new SQLException("Erro ao conectar ao banco de dados");
        }

    }
}
