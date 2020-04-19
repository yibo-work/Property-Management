package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Clrvn
 */
@Controller
public class HelloController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute("USER");
        session.invalidate();
        session.getServletContext().removeAttribute(session.getId());
        return "login";
    }

    @GetMapping("/index")
    public String index(HttpSession session) {
        //默认，不用登录
//        User user = new User();
//        user.setName("chen");
//        user.setPassword("123qwe");
//        session.setAttribute("USER", user);
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    /**
     * 属性管理
     */
    @GetMapping("/propManage")
    public String propManage() {
        return "propManage";
    }

    @GetMapping("/propUpdate")
    public String propUpdate() {
        return "propUpdate";
    }

    @GetMapping("/propAdd")
    public String propAdd() {
        return "propAdd";
    }

    /**
     * 数据录入
     */
    @GetMapping("/dataManage")
    public String dataManage() {
        return "dataManage";
    }

    @GetMapping("/dataUpdate")
    public String dataUpdate() {
        return "dataUpdate";
    }

    @GetMapping("/dataAdd")
    public String dataAdd() {
        return "dataAdd";
    }
}
