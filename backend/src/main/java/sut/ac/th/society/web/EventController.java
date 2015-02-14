package sut.ac.th.society.web;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.society.domain.Event;
import sut.ac.th.society.repository.EventRepository;





@RestController
public class EventController {
	@Autowired
	private	EventRepository Repo;
	
	@RequestMapping("/event/add")
	@ResponseBody
	public void add(@Valid @RequestBody Event even){
		//System.out.println(even.getClub());
		Repo.save(even);
		
	}
	@RequestMapping("/event/post")
	@ResponseBody
	public List<Event> showall(){
		return (List<Event>) Repo.findAll();
	}
	
	@RequestMapping("/event/post/{id}")
	@ResponseBody
	public Event showByid(@PathVariable("id") Long id){
		return Repo.findOne(id);
	}
}
