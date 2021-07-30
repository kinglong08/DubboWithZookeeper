package com.lch2.dubbo.web;

import com.lch02.dubbo.model.User;
import com.lch02.dubbo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    private UserService service;

    @RequestMapping("/userDetail")
    public String userDetail(Model model, Integer id){
        User user = service.queryUserById(id);

        Integer allUserCount = service.queryAllUserCount();

        model.addAttribute("user", user);
        model.addAttribute("count", allUserCount);
        return "userDetail";
    }
}
