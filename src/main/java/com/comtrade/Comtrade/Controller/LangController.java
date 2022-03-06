package com.comtrade.Comtrade.Controller;
import com.comtrade.Comtrade.Model.LangModel;
import com.comtrade.Comtrade.Service.LangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

    @Profile({"dev", "ext", "default"})
    @CrossOrigin(origins = "*")
    @RestController
    public class LangController{

    @Autowired
    private LangService langService;

    @GetMapping("")
    public ModelAndView indexPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/hello-rest")
    public String helloRest() {
        return "Hello World";
    }


    @GetMapping("/hello/{param}")
    public String getByLanguage(@PathVariable(name = "param") String param) {
        return this.langService.getByParam(param);
    }

    @GetMapping("/all")
    public Map<String,String> getAll() {
        return this.langService.getAll();
    }

    @PostMapping("/add-country")
    public RedirectView post(@ModelAttribute("lang") LangModel lang) {
            this.langService.save(lang);
            return new RedirectView("secure/hello");
    }

    @Profile({"dev", "default"})
    @CrossOrigin(origins = "*")
    @RestController
    public class helloController {

        @GetMapping("/hello")
        public ModelAndView htmlPage() {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("helloWorld");
            return modelAndView;
        }
    }
}

