package com.pthon.naumen.contollers;

import com.pthon.naumen.models.Notes;
import com.pthon.naumen.repo.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Blob;
import java.util.Date;

@Controller
public class NoteController {

    @Autowired
    private NotesRepository notesRepository;

    @PostMapping("requestNotes")
    public String requestNotes(@RequestParam String search,
                               @RequestParam String startDate,
                               @RequestParam String endDate,
                               @RequestParam(value = "dateLimit", required = false) boolean dateLimit,
                               @RequestParam int outputLimit,
                               Model model) {
        //if date empty
        Iterable<Notes> notes = null;
        if (!dateLimit && !startDate.equals("") && !endDate.equals("")) {
            if (search.equals("")) {
                notes = notesRepository.findByDate(startDate, endDate, outputLimit);
            } else {
                notes = notesRepository.findByDateAndSearch(startDate, endDate, outputLimit, search);
            }
        }
        if (dateLimit) {
            if (search.equals("")) {
                notes = notesRepository.findWithoutDateAndSearch(outputLimit);
            } else {
                notes = notesRepository.findWithoutDateWithSearch(outputLimit, search);
            }
        }

        model.addAttribute("notes", notes);
        return "requestNotes";
    }

    @PostMapping("addNote")
    public String addNote(@RequestParam String title, @RequestParam String content, Model model) {
        //current date
        Date time = new Date();

        Notes notes = new Notes(title,content, time);
        notesRepository.save(notes);
        return "successRequest";
    }

    @PostMapping("requestDelete")
    public String requestDelete(@RequestParam long id, Model model) {
        notesRepository.deleteById(id);
        return "successRequest";
    }


}
