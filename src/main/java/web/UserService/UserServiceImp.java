package web.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDao;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserDao userDao;
    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public List<User> getUsers() {

        return userDao.getUsers();
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Transactional
    @Override
    public void changeDataUser(Long id, User userAfter) {
        userDao.changeDataUser(id,userAfter);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }
}
