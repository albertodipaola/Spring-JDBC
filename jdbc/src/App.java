import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        final String connectionString = "jdbc:mysql://localhost:3306/java?user=root&password=root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(connectionString);
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM libro l JOIN autore a ON l.autore_id=a.id";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.print(resultSet.getLong("id") + " ");
                System.out.print(resultSet.getString("titolo") + "  |  ");
                System.out.print(resultSet.getString("nome") + " ");
                System.out.print(resultSet.getString("cognome") + "   ");
                System.out.println(" ");
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
