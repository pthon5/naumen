package com.pthon.naumen.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    //Home page
    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    //Note view and delete page
    @GetMapping("/viewNotes")
    public String viewNotes(Model model) {
        return "viewNotes";
    }

}
