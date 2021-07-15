package com.pthon.naumen.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoteController {

    @GetMapping("requestNotes")
    public String requestNotes(Model model) {
        return "";
    }

}
