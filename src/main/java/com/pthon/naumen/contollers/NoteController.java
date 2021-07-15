package com.pthon.naumen.contollers;

import com.pthon.naumen.models.Notes;
import com.pthon.naumen.repo.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoteController {

    @Autowired
    private NotesRepository notesRepository;

    @GetMapping("requestNotes")
    public String requestNotes(Model model) {
        Iterable<Notes> notes = notesRepository.findAll();
        model.addAttribute("notes", notes);
        return "requestNotes";
    }

}
