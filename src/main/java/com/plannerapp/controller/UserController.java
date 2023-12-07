package com.plannerapp.controller;

import com.plannerapp.model.dto.user.UserRegisterBindingModel;
import com.plannerapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel")
                                     UserRegisterBindingModel userRegisterBindingModel){
        return new ModelAndView("register");
    }
    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel") @Valid
                                 UserRegisterBindingModel userRegisterBindingMode,
                                 BindingResult bindingResult){

        return new ModelAndView("register");
    }
}
