package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> getUsers();
    void deleteUser(Long id);
    void changeDataUser(Long id, User userAfter);

    User getById(Long id);
}
