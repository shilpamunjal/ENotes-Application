package com.example.ENOTES.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ENOTES.entity.Note;


public interface NotesRepository extends JpaRepository<Note,Integer>{


}
