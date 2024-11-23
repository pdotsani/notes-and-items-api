package com.example.demo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class NoteController {
    private NoteRepository noteRepository;

    static class ItemWithNoteID extends Item {
        Long noteId;
        public ItemWithNoteID(String bodyPart, String muscles, Long noteId) {
            super(bodyPart, muscles);
            this.noteId = noteId;
        }
    }

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @PostMapping("/saveNote")
    @CrossOrigin(origins = "*")
    public String saveNote(@RequestBody Note note) {
        if(note == null) {
            return "invalid note";
        }
        this.noteRepository.save(note);
        return "success";
    }

//    @PostMapping("/addItemToNote")
//    @CrossOrigin(origins = "*")
//    public void addItemToNote(@RequestBody ItemWithNoteID item) {
//        Optional<Note> note = this.noteRepository.findById(item.noteId);
//        if (note.isPresent()) {
//            Note n = note.get();
//            n.addItem(item);
//        }
//    }

    @GetMapping("/getNotes")
    @CrossOrigin(origins = "*")
    public List<Note> getAllNotes(@RequestParam String owner) {
        Iterable<Note> notes = this.noteRepository.findByOwner(owner);
        List<Note> noteList = new ArrayList<>();
        notes.forEach(noteList::add); {}
        return noteList;
    }
}
