package springtutorial.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtutorial.northwind.business.abstracts.UserService;
import springtutorial.northwind.core.dataAccess.UserDao;
import springtutorial.northwind.core.entities.User;
import springtutorial.northwind.core.utilities.results.*;


@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("User added");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>("User found",
                this.userDao.findByEmail(email));
    }

}
