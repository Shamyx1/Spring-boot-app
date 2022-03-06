package com.comtrade.Comtrade.Service;

import com.comtrade.Comtrade.Model.AuthModel;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class UserService {

    public UserService() {}

    public ModelAndView isValidUser(AuthModel model) {
        ModelAndView modelAndView = new ModelAndView();
        if(model.getUsername().equals("admin") && model.getPassword().equals("admin")) {
            modelAndView.setViewName("admin");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
