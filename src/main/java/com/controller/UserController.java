package com.controller;

import com.enums.ResultFailureEnum;
import com.pojo.User;
import com.service.UserService;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ResultVO login(@RequestBody User loginUser, HttpSession session) {
        User user = userService.login(loginUser);
        if (user != null) {
            session.setAttribute("USER", user);
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.failure(ResultFailureEnum.LOGIN_ERROR);
        }

    }

    @RequestMapping("/loginOut")
    public void loginOut(HttpSession session) {
        session.removeAttribute("USER");
        session.invalidate();
    }


    @RequestMapping("/register")
    public ResultVO addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResultVOUtil.success();
    }


}
