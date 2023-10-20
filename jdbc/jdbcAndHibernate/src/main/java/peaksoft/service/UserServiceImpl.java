package peaksoft.service;

import peaksoft.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
//    private final Connection connection= JdbsConfig.getConnection();
    private UserDao userDao=new UserDaoJdbcImpl();

    public void createUsersTable() {
        userDaoJdbc.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoJdbc.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoJdbc.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
        userDaoJdbc.removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> users =userDaoJdbc.getAllUsers();
        return users;
    }

    public void cleanUsersTable() {
        userDaoJdbc.cleanUsersTable();
    }
}
