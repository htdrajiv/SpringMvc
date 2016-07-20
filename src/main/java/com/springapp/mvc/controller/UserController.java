package com.springapp.mvc.controller;

import com.springapp.mvc.dataAccess.UserAccess;
import com.springapp.mvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Rajiv on 7/18/2016.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping(value = "/addNewUser", method = RequestMethod.GET)
    public ModelAndView addNewUser(){
        ModelAndView modelAndView = new ModelAndView("addUser");
        return modelAndView;
    }

    @RequestMapping(value = "/saveUser")
    public String saveUser(User user) throws SQLException {
        UserAccess userAccess = new UserAccess();
        userAccess.addUser(user);
        return "redirect:/user/userList";
    }

    @RequestMapping(value = "/userList")
    public ModelAndView listUser(ModelMap model) throws SQLException {
        UserAccess userAccess = new UserAccess();
        List<User> userList = userAccess.getUsers();
        model.addAttribute("users",userList);
        ModelAndView modelAndView = new ModelAndView("userList");
        return modelAndView;
    }


}
