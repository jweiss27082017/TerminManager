package ch.zli.TerminManager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class WebController {

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/home")
    public String Home() {
        return "Home";
    }
    @RequestMapping(value = "/signin")
    public String SignIn() {
        return "SignIn";
    }
    @RequestMapping(value = "/signup")
    public String SignUp() {
        return "SignUp";
    }
}
