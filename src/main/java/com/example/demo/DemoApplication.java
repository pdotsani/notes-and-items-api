package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ai.peoplecode.OpenAIConversation;
import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@SpringBootApplication
public class DemoApplication {
//  @Autowired
//  BookRepository bookRepository;
  @Autowired
  NoteRepository noteRepository;

  @Autowired
  private Environment env;

  public static void main(String[] args) {
     SpringApplication.run(DemoApplication.class, args);
  }

  @ShellMethod("saves a note")
  public String saveNote(String owner, String patient, String note) {
      Note savedNote = this.noteRepository.save(new Note(owner, patient, note));
      return savedNote.toString();
  }

  @ShellMethod("shows all notes")
  public String findAllNotes() {
      Iterable<Note> savedNotes = this.noteRepository.findAll();
      return Lists.newArrayList(savedNotes).toString();
  }

    @ShellMethod("shows all notes")
    public String findNotesByOwner(String owner) {
        Iterable<Note> savedNotes = this.noteRepository.findByOwner(owner);
        return Lists.newArrayList(savedNotes).toString();
    }

    @ShellMethod("summarize item")
    public String summarizeItem(String body, String muscle, String memo) {
        String OPENAIKEY = env.getProperty("app.api-key");
        OpenAIConversation conversation = new OpenAIConversation(OPENAIKEY, "gpt-4o-mini");
        String context = "body part: " + body + ". musscles involved: " + muscle;

        return conversation.askQuestion(context, "can you create one brief paragraph with this information and this memo: " + memo);
    }
}
