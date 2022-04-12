package com.comtrade.Comtrade.Service;

import com.comtrade.Comtrade.Model.AuthModel;
import org.h2.engine.User;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;



@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    UserService userService = new UserService();
    ModelAndView modelAndView = new ModelAndView();
    AuthModel authModel = Mockito.mock(AuthModel.class);

//    @BeforeClass
//    public void setUp()
//    {
//        userService = new UserService();
//    }

    @Test
    void  testIsValidUser() {
        when(authModel.getUsername()).thenReturn("admin");
        when(authModel.getPassword()).thenReturn("admin");
        ModelAndView modelAndView = userService.isValidUser(authModel);
        assertEquals("admin", modelAndView.getViewName());
    }
    @Test
    void testIsNotValidUser(){
        when(authModel.getPassword()).thenReturn("admin");
        when(authModel.getUsername()).thenReturn("error");
        ModelAndView modelAndView = userService.isValidUser(authModel);
        assertEquals("login", modelAndView.getViewName());

    }
    @Test
    void testIsNotValidUser2(){
        when(authModel.getPassword()).thenReturn("error");
        when(authModel.getUsername()).thenReturn("admin");
        ModelAndView modelAndView = userService.isValidUser(authModel);
        assertEquals("login", modelAndView.getViewName());

    }
    @Test
    void testIsNotValidUser3(){
        when(authModel.getPassword()).thenReturn("error");
        when(authModel.getUsername()).thenReturn("error");
        ModelAndView modelAndView = userService.isValidUser(authModel);
        assertEquals("login", modelAndView.getViewName());

    }
}