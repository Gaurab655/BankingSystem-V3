package Swift.bvv2.bvv2.Controller;
import Swift.bvv2.bvv2.Entity.User;
import Swift.bvv2.bvv2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class myController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        System.out.println(user);
        userRepository.save(user);
        return "redirect:/";
    }
}
