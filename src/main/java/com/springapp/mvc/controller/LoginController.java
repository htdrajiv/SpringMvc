package com.springapp.mvc.controller;

import com.springapp.mvc.dataAccess.UserAccess;
import com.springapp.mvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

/**
 * Created by Rajiv on 7/16/2016.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @RequestMapping(value = "/loginForm",method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView model = new ModelAndView("login");
        return model;
    }

    @RequestMapping(value = "/submitLogin",method = RequestMethod.POST)
    public ModelAndView processLogin(@RequestParam("uname") String userName, @RequestParam("pass") String password,ModelMap model){
        ModelAndView m = new ModelAndView("hello");

        UserAccess userAccess = new UserAccess();
        try {
            User user = userAccess.getUser(userName);
            if(user==null || !user.getPassword().equals(password)){
                m = new ModelAndView("denied");
            }else {
                model.addAttribute("message", "Congratulations "+user.getFullName()+" !! you have successfully logged in.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }
}
