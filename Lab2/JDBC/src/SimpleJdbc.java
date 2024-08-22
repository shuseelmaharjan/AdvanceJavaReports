import java.sql.*;
import java.sql.Statement;


public class JdbcExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/fms";
        String username = "root";
        String password = "";

        try {
            //Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            //Create a statement
            Statement statement = connection.createStatement();

            //Execute Insert Query
            String insertSql = "INSERT INTO users (username, email, password) VALUES ('shuseel maharjan', 'mailtoshuseel@gmail.com', 'shuseel')";
            int rowsInserted = statement.executeUpdate(insertSql);
            System.out.println("Rows inserted: " + rowsInserted);

            //Execute Select Statement
            String selectSql = "SELECT id, username, email FROM users";
            ResultSet resultSet = statement.executeQuery(selectSql);

            //Process the Result
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String uname = resultSet.getString("username");
                String email = resultSet.getString("email");

                System.out.println("ID: " + id + ", Username: " + uname + ", Email: " + email);
            }

            //Close resourses
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
