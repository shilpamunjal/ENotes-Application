package com.example.ENOTES.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ENOTES.entity.Note;

import com.example.ENOTES.service.NotesInterface;


import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	
	

	
	@Autowired
	private NotesInterface noteservice;
	
	@GetMapping("/AddNote")
	public String  index() {
		return "AddNote";
	}
	@GetMapping("/home")
	public String login() {
		return "Home";
	}
	
	@GetMapping("/viewNotes")
	public String viewNotes(Model m) {
		System.out.println("View Notes");
		
		List<Note> notes=noteservice.findAllNotes();
		m.addAttribute("notesList", notes);
		return "ViewNotes";
	}
	
	@GetMapping("/editNotes/{id}")
	public String editNotes(@PathVariable int id,Model m) {
	Note notes=noteservice.getNotesById(id);
	m.addAttribute("n",notes);
		return "EditNotes";
	}
	

	@GetMapping("/deleteNotes/{id}")
	public String deleteNotes(@PathVariable int id,HttpSession session) {
		System.out.println("Delete Notes");

	boolean notes=noteservice.deleteNotes(id);
	
	
	return "Home";
	}

	
	@PostMapping("/saveNotes")
	public String saveNotes(@ModelAttribute Note notes) {
		notes.setDate(LocalDate.now());

		Note note=noteservice.saveNotes(notes);
		
		return "Home";
	}
	
	@PostMapping("/update")
	public String updateNotes(@ModelAttribute Note notes,HttpSession session) {
	
		System.out.println("update notes");
		notes.setDate(LocalDate.now());
		Note note=noteservice.saveNotes(notes);
		
		return "Home";
	}

}
