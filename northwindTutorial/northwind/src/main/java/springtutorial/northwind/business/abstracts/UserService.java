package springtutorial.northwind.business.abstracts;

import springtutorial.northwind.core.entities.User;
import springtutorial.northwind.core.utilities.results.DataResult;
import springtutorial.northwind.core.utilities.results.Result;
import springtutorial.northwind.entities.concretes.Product;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}
