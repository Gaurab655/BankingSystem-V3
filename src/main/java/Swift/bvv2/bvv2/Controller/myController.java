package Swift.bvv2.bvv2.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class myController {
    @RequestMapping("/index")
    public String cat(){
        return "index";
    }
}
