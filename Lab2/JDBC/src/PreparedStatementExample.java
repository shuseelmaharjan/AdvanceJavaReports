import java.sql.*;

public class PreparedStatementExample {

    private static final String URL = "jdbc:mysql://localhost:3306/College";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public void addUser(User user) {
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());

            int rowsInserted = stmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        User user = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

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
        PreparedStatementExample example = new PreparedStatementExample();

        // Create a new User
        User newUser = new User();
        newUser.setUsername("john_doe");
        newUser.setEmail("john@example.com");
        newUser.setPassword("password123");

        // Add the user to the database
        example.addUser(newUser);

        // Retrieve and print the user from the database
        User retrievedUser = example.getUser(1); // assuming ID 1 exists in the database
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

class User {
    private int id;
    private String username;
    private String email;
    private String password;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
