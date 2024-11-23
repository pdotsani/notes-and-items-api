package com.example.demo;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@SpringBootApplication
public class DemoApplication {
//  @Autowired
//  BookRepository bookRepository;
  @Autowired
  NoteRepository noteRepository;

  public static void main(String[] args) {
     SpringApplication.run(DemoApplication.class, args);
  }

//  @ShellMethod("Saves a book to Cloud Datastore: save-book <title> <author> <year>")
//  public String saveBook(String title, String author, int year) {
//     Book savedBook = this.bookRepository.save(new Book(title, author, year));
//     return savedBook.toString();
//  }
//
//  @ShellMethod("Loads all books")
//  public String findAllBooks() {
//     Iterable<Book> books = this.bookRepository.findAll();
//     return Lists.newArrayList(books).toString();
//  }
//
//  @ShellMethod("Loads books by author: find-by-author <author>")
//  public String findByAuthor(String author) {
//     List<Book> books = this.bookRepository.findByAuthor(author);
//     return books.toString();
//  }
//
//  @ShellMethod("Loads books published after a given year: find-by-year-after <year>")
//  public String findByYearAfter(int year) {
//     List<Book> books = this.bookRepository.findByYearGreaterThan(year);
//     return books.toString();
//  }
//
//  @ShellMethod("Loads books by author and year: find-by-author-year <author> <year>")
//  public String findByAuthorYear(String author, int year) {
//     List<Book> books = this.bookRepository.findByAuthorAndYear(author, year);
//     return books.toString();
//  }
//
//  @ShellMethod("Removes all books")
//  public void removeAllBooks() {
//     this.bookRepository.deleteAll();
//  }

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

//    @ShellMethod("add item to note")
//    public void addItemToNote(String bodyPart, String muscle, int noteID) {
//        NoteController.ItemWithNoteID itemWith = new NoteController.ItemWithNoteID(bodyPart, muscle, (long) noteID);
//        Optional<Note> note = this.noteRepository.findById(itemWith.noteId);
//        if (note.isPresent()) {
//            Note n = note.get();
//            n.addItem(itemWith);
//        }
//    }
}
