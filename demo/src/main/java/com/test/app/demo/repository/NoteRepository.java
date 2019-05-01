package com.test.app.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.test.app.demo.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}