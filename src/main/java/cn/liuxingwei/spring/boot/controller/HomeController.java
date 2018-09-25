package cn.liuxingwei.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(method = GET)
    public String home(Model model) {
        model.addAttribute("text", "Hello, world!");
        return "home";
    }
}
