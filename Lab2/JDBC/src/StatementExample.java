import java.sql.*;

public class StatementExample {

    private static final String URL = "jdbc:mysql://localhost:3306/fms";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    //method to insert user
    public void addUser(User user) {
        String sql = "INSERT INTO users (username, email, password) VALUES ('"
                + user.getUsername() + "', '"
                + user.getEmail() + "', '"
                + user.getPassword() + "')";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            int rowsInserted = stmt.executeUpdate(sql);
            System.out.println("Rows inserted: " + rowsInserted);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method to call database user with id
    public User getUser(int id) {
        String sql = "SELECT * FROM users WHERE id = " + id;
        User user = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) {
        StatementExample example = new StatementExample();

        //create new user
        User newUser = new User();
        newUser.setUsername("shuseel");
        newUser.setEmail("shuseel@gmail.com");
        newUser.setPassword("password");

        //add user to database
        example.addUser(newUser);

        //retrive user with userid
        User retrievedUser = example.getUser(1);
        if (retrievedUser != null) {
            System.out.println("Retrieved User:");
            System.out.println("ID: " + retrievedUser.getId());
            System.out.println("Username: " + retrievedUser.getUsername());
            System.out.println("Email: " + retrievedUser.getEmail());
            System.out.println("Password: " + retrievedUser.getPassword());
        } else {
            System.out.println("User not found.");
        }
    }
}
