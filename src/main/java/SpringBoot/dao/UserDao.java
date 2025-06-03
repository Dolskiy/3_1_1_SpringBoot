package SpringBoot.dao;

import SpringBoot.model.User;
import java.util.List;

public interface UserDao {
    public void add(User user);
    public List<User> listUsers();
    public void deleteUserById(int id);
    public void updateUser(int id, User user);
    public User getUserById(int id);
}