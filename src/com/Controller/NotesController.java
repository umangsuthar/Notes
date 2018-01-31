package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.DAO.*;
import com.DAO.NotesDAO;
import com.DTO.Notes;

@Controller
public class NotesController {

	@Autowired
	private NotesDAO notesDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView Main() {

		ModelAndView model = new ModelAndView("index");
		return model;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("notes") Notes note) {
		notesDao.add(note);
		return "index";
	}

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView display() {
		ModelAndView model = new ModelAndView("display");
		List<Notes> ls = notesDao.display();
		model.addObject("notes", ls);
		return model;
	}
	
	@RequestMapping(value="/delete/{id}", method= RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("display");
		notesDao.delete(id);
		return new ModelAndView("redirect:/display");
	}
	
	@RequestMapping(value="/update/{id}",method= RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("update");
		Notes note = notesDao.get(id);
		model.addObject("note", note);
		return model;
	}
	
	@RequestMapping(value="/edit", method= RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute("note") Notes note)
	{
		ModelAndView model = new ModelAndView("display");
		notesDao.update(note);
		return new ModelAndView("redirect:/display");
	}
}