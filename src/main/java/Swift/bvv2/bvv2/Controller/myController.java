package Swift.bvv2.bvv2.Controller;
import Swift.bvv2.bvv2.Entity.User;
import Swift.bvv2.bvv2.Repository.UserRepository;
import Swift.bvv2.bvv2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("fullName")
public class myController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        User existingUser = userService.findByEmail(user.getEmail());
        if (existingUser != null) {
            model.addAttribute("emailError", "Email already exists");
            model.addAttribute("user", user);
            model.addAttribute("activeTab", "register");
            return "index";
        }
        System.out.println(user);
        userService.registerUser(user);
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model) {
        User existingUser = userService.findByEmail(user.getEmail());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            String fullName = existingUser.getFullName();
            model.addAttribute("fullName", fullName);
            return "redirect:/home";
        } else {
            model.addAttribute("loginError", "Invalid email or password."); // Set error message for invalid login
            model.addAttribute("activeTab", "login"); // Keep login tab active
            return "index";
        }
    }
    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/index";
    }
    //test test test
    //test-tr
    //test test test
}
