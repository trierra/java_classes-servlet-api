package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionExample {

    String dbUrl = "jdbc:mysql://localhost:3306/sampledb";
    String username = "root";
    String password = "qwerty";

    Connection connection;

    public void connect() {

        try {
            connection = DriverManager.getConnection(dbUrl, username, password);

            if (connection != null) {
                System.out.println("System connected!");
            } else {
                System.out.println("OOps, something went wrong :( ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createUser() throws SQLException {

        String sql = "INSERT INTO users (username, password, fullname, email ) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, "bill");
        statement.setString(2, "secretPassw");
        statement.setString(3, "gates");
        statement.setString(4, "bill.gates@microsoft.com");

        int rowInserted = statement.executeUpdate();


        if (rowInserted > 0) {
            System.out.println("New user inserted!");
        }

    }


    public User getUserById(int id) throws SQLException {

        String sql = "Select * from users WHERE user_id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        User user = new User();

        if (resultSet.next()) {

            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setFullName(resultSet.getString("fullname"));

        }

        return user;
    }


    public List<User> getUserList() throws SQLException {

        String sql = "Select * from users";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        ArrayList<User> userArrayList = new ArrayList<User>();

        User user;

        while (resultSet.next()) {

            user = new User();
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setFullName(resultSet.getString("fullname"));
            userArrayList.add(user);

        }

        return userArrayList;
    }

    public static void main(String[] args) {


        ConnectionExample connectionExample = new ConnectionExample();
        connectionExample.connect();

        try {

            connectionExample.createUser(); // call method createUser

            User user = connectionExample.getUserById(1); //receive user from db by ID

            System.out.println(user.getUsername() + " " + user.getFullName());

            int usersAmount = connectionExample.getUserList().size();

            System.out.println(usersAmount);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
