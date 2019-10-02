package ch.zli.TerminManager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    //Hier wird die Index Seite zurückgegeben
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    //Hier wird die Home Seite zurückgegeben
    @RequestMapping(value = "/home")
    public String Home() {
        return "Home";
    }

    //Hier wird die SignIn Seite zurückgegeben
    @RequestMapping(value = "/signin")
    public String SignIn() {
        return "SignIn";
    }

    //Hier wird die SignUp Seite zurückgegeben
    @RequestMapping(value = "/signup")
    public String SignUp() {
        return "SignUp";
    }
}
