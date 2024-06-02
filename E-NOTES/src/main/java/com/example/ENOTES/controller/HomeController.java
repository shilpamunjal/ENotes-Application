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
		//View Notes
		//Hibernate: select n1_0.id,n1_0.date,n1_0.description,n1_0.title from note n1_0
		//Hibernate: select n1_0.id,n1_0.date,n1_0.description,n1_0.title,n1_0.user_id from notes n1_0 where n1_0.user_id is null
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
		//Delete Notes
		//Hibernate: select n1_0.id,n1_0.date,n1_0.description,n1_0.title from note n1_0 where n1_0.id=?
		//Hibernate: delete from note where id=?
		//http://localhost:8085/deleteNotes/3
	boolean notes=noteservice.deleteNotes(id);
	
	
	return "Home";
	}

	
	@PostMapping("/saveNotes")
	public String saveNotes(@ModelAttribute Note notes) {
		notes.setDate(LocalDate.now());
	//	Hibernate: insert into notes (date,description,title,user_id) values (?,?,?,?)
		Note note=noteservice.saveNotes(notes);
		
		return "Home";
	}
	
	@PostMapping("/update")
	public String updateNotes(@ModelAttribute Note notes,HttpSession session) {
		//Hibernate: select n1_0.id,n1_0.date,n1_0.description,n1_0.title from note n1_0 where n1_0.id=?
				//Hibernate: update note set date=?,description=?,title=? where id=?
		System.out.println("update notes");
		notes.setDate(LocalDate.now());
		Note note=noteservice.saveNotes(notes);
		
		return "Home";
	}

}
