package com.example.ENOTES.service;

import java.util.List;

import com.example.ENOTES.entity.Note;


public interface NotesInterface {
	public Note saveNotes(Note notes);
	public List<Note> findAllNotes();
	public Note getNotesById(int id);
	
	
	public Note updateNotes(Note note);
	public boolean deleteNotes(int id);
	
	

}
