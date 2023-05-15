package web.UserService;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;
@Repository
public interface UserService {


    void addUser(User user);

    List<User> getUsers();
    void deleteUser(Long id);
    void changeDataUser(Long id, User userAfter);
    User getById(Long id);
}
