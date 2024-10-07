package Swift.bvv2.bvv2.Services;

import Swift.bvv2.bvv2.Entity.User;
import Swift.bvv2.bvv2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void registerUser(User user){
        userRepository.save(user);
    }
}
