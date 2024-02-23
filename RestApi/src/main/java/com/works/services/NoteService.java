package com.works.services;

import com.works.entities.Note;
import com.works.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService {

    final NoteRepository repository;

    public ResponseEntity save(Note note) {
        repository.save(note);
        return new ResponseEntity(note, HttpStatus.OK);
    }

    public ResponseEntity list() {
        return new ResponseEntity(repository.findAll(), HttpStatus.OK);
    }

}
