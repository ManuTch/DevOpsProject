package my.app.taxeapp.repository;

import my.app.taxeapp.bean.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
