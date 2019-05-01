package com.test.app.demo.controller;

import com.test.app.demo.repository.NoteRepository;

import java.util.List;

import javax.validation.Valid;

import com.test.app.demo.exception.ResourceNotFoundException;
import com.test.app.demo.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class NotesController{
    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/notes")
    public List<Note> getNotes(){
        return noteRepository.findAll();
    }

    @PostMapping("/notes")
    public Note creaNote(@Valid @RequestBody Note note){
        return noteRepository.save(note);
    }

    @GetMapping("notes/{id}")
    public Note getNote(@PathVariable(value = "id") Long noteId){
        return noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note","id",noteId));
    }

    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId, @Valid @RequestBody Note noteDetails){
        Note theNote=noteRepository.findById(noteId).orElseThrow(()->new ResourceNotFoundException("Note","id",noteId));
        theNote.setContent(noteDetails.getContent());
        theNote.setTitle(noteDetails.getTitle());
        Note updatedNote=noteRepository.save(theNote);
        return updatedNote;
    }

    @DeleteMapping("/notes/{id}")
    public String deleteNote(@PathVariable(value = "id") Long noteId){
        Note theNote=noteRepository.findById(noteId).orElseThrow(()->new ResourceNotFoundException("Note","id",noteId));
        noteRepository.delete(theNote);
        return "OK";
    }

}