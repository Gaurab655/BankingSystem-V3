package Swift.bvv2.bvv2.controller;
import Swift.bvv2.bvv2.model.User;
import Swift.bvv2.bvv2.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import Swift.bvv2.bvv2.Repository.UserRepository;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("fullName")
public class myController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, HttpSession httpSession){
        User exestingUser = userService.findByEmail(user.getEmail());
        if (exestingUser!=null ){
           httpSession.setAttribute("emailError","Email with this msg already exists");
            httpSession.setAttribute("User",user);
            httpSession.setAttribute("activeTab","register");
            return "index";
        }else {
            System.out.println(user);
            userService.registerUser(user);
            userService.nameDisplay(user,httpSession);
            return "redirect:/home";

        }

    }
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, HttpSession httpSession){
       User existUser= userService.findByEmail(user.getEmail());
       if (existUser!=null && existUser.getPassword().equals(user.getPassword())){
           userService.nameDisplay(user,httpSession);
           return "redirect:/home";
       }
        httpSession.setAttribute("loginError","Invalid email or password");
        httpSession.setAttribute("activeTab","login");
       return "index";

    }
    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus){
        sessionStatus.setComplete(); //clears" the session data, meaning the user is no longer considered logged in.
        return "redirect:/index";
    }

}
