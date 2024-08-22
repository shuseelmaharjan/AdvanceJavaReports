import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcExample {

    public static void main(String[] args) {
        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/fms";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create a Statement object
            Statement statement = connection.createStatement();

            // Execute an INSERT query using Statement
            String insertQuery = "INSERT INTO users (username, name) VALUES ('jane_doe', 'Jane Doe')";
            int rowsAffected = statement.executeUpdate(insertQuery);
            System.out.println("Rows affected by Statement: " + rowsAffected);

            // Create a PreparedStatement object
            String preparedInsertQuery = "INSERT INTO users (username, name) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(preparedInsertQuery);
            preparedStatement.setString(1, "john_doe");
            preparedStatement.setString(2, "John Doe");

            // Execute the INSERT query using PreparedStatement
            rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected by PreparedStatement: " + rowsAffected);

            // Execute a SELECT query using Statement
            String selectQuery = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Process the ResultSet
            while (resultSet.next()) {
                String user = resultSet.getString("username");
                String name = resultSet.getString("name");
                System.out.println("Username: " + user + ", Name: " + name);
            }

            // Close resources
            resultSet.close();
            statement.close();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
