package com.comtrade.Comtrade.Controller;


import com.comtrade.Comtrade.Model.AuthModel;
import com.comtrade.Comtrade.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Profile({"dev", "ext", "default"})
@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/secure/hello")
    public ModelAndView htmlPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/secure/hello")
    public ModelAndView isValidUser (@ModelAttribute("authModel") AuthModel model) {
        return this.userService.isValidUser(model);
    }

}
