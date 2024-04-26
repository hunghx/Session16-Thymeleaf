package ra.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.thymeleaf.model.Student;

@Controller
public class HomeController {
    @RequestMapping
    public String home(Model model){
        model.addAttribute("message","hello world");
        model.addAttribute("student",new Student(1,"Nguyễn Ngọc Ánh",20));
        model.addAttribute("array",new int[]{1,2,3,4,5,9,10});
        model.addAttribute("totalPage",10);
        model.addAttribute("html","<h1>HTML</h1>");

        return "home";
    }
    @RequestMapping("/student/list")
    public String list(){
        return "student/student";
    }
}
