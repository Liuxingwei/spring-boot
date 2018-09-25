package cn.liuxingwei.spring.boot.controller;

import cn.liuxingwei.spring.boot.orm.domain.UserDao;
import cn.liuxingwei.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        UserDao userDao = new UserDao();
        userDao.setUserName("wangwu");
        userDao.setPassword("123456");
        userDao.setUserType((short)20);

        userService.add(userDao);

        model.addAttribute("text", "success!");

        return "useradd";
    }
}
