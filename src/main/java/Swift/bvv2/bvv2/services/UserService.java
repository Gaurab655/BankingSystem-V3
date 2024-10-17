package Swift.bvv2.bvv2.services;

import Swift.bvv2.bvv2.Repository.UserRepository;
import Swift.bvv2.bvv2.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user){
         userRepository.save(user);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void nameDisplay(User user,HttpSession httpSession){
        User existUser= findByEmail(user.getEmail());
        String fullname = existUser.getFullName();
//        String email = existUser.getEmail();
        httpSession.setAttribute("fullName",fullname);
//        httpSession.setAttribute("email",email);

    }
}
