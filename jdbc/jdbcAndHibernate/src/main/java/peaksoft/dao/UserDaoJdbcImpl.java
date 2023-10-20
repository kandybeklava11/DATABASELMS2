package peaksoft.dao;

import peaksoft.model.User;

import java.util.List;

public class UserDaoJdbcImpl  implements UserDao {
private final Connection connection=Util.getConnection();


    public void createUsersTable() {
        String sql=
                "CREATE TABLE IF NOT EXISTS Userrr("+
                        "id SERIAL PRIMARY KEY,"+
                        "first_name VARCHAR(50),"+
                        "last_name VARCHAR(50),"+
                        "age int"+
                        ")";

        Statement statement;
        try {
            statement=connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Table Successfully created!");
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }

    public void dropUsersTable() {
        String sql=" DROP TABLE IF NOT EXISTS Userrr";
        Statement statement;
        try {
            statement=connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Successfully deleted!");
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        PreparedStatement preparedStatement;

        String sql="INSERT INTO Userrr(name,lastName,age)VALUE(?,?,?)";

        try {

            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setInt(3,age);
            preparedStatement.executeUpdate();
            System.out.println("Successfully saved!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        PreparedStatement preparedStatement;

        String sql="DELETE FROM Userrr WHERE id=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            int check=preparedStatement.executeUpdate();
            if(check>0){
                System.out.println("Deleted user with id"+id);
            }else{
                System.out.println("Not fount");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM user";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getByte("age")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving users from database", e);
        }

        return users;

    }

    public void cleanUsersTable() {
        Statement statement;

        String sql="DELETE * FROM Userrr";
        try {
            statement=connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Successfully deleted!");
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}