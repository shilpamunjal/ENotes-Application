package com.example.ENOTES.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ENOTES.entity.Note;

import com.example.ENOTES.repository.NotesRepository;

@Service
public class NotesInterfaceImpl implements NotesInterface{

	@Autowired
	private NotesRepository notesRepository;
	
	@Override
	public Note saveNotes(Note notes) {
		return notesRepository.save(notes);
		// TODO Auto-generated method stub
	
	}

	@Override
	public List<Note> findAllNotes() {
		// TODO Auto-generated method stub
		return  notesRepository.findAll();
	}

	@Override
	public Note getNotesById(int id) {
		// TODO Auto-generated method stub
		return notesRepository.findById(id).get();
	}

	/*
	 * @Override public List<Notes> getNotesByUser(User user) { // TODO
	 * Auto-generated method stub return notesRepository.findByUser(user); }
	 */

	@Override
	public Note updateNotes(Note note) {
		// TODO Auto-generated method stub
		return notesRepository.save(note);
	}

	@Override
	public boolean deleteNotes(int id) {
		Note notes=notesRepository.findById(id).get();
		if(notes !=null) {
			notesRepository.delete(notes);
			return true;
		}
		// TODO Auto-generated method stub
	return false;
	}

}
