package my.app.taxeapp.service;

import my.app.taxeapp.bean.User;
import my.app.taxeapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private static UserRepository userRepository;

    public static User getUserByCin(String cin) {
        // Implement logic to retrieve User by Cin from the repository
        // This is just a simple example, and you should modify it based on your entity and repository structure
        Optional<User> optionalUser = userRepository.findByCin(cin);

        return optionalUser.orElse(null);
    }

    public static User createUser(User user) {
        return userRepository.save(user);
    }
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
