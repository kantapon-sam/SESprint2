package sut.ac.th.society.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.society.domain.Comment;
import sut.ac.th.society.repository.ClubRepository;
import sut.ac.th.society.repository.StatusRepository;

@RestController
public class StatusController {
	@Autowired
	private	StatusRepository libRepo;
	@Autowired
	private ClubRepository clu;
	@RequestMapping("/status/add/{id}")
	@ResponseBody
	public void add(@Valid @RequestBody Comment comm, @PathVariable("id") Long id){
		comm.setClub(clu.findOne(id));
		libRepo.save(comm);
	}
	@RequestMapping("/status/post/{id}")
	@ResponseBody
	public List<Comment> showcomment(@PathVariable("id") Long id) {
		return (List<Comment>) libRepo.findByClub(clu.findOne(id));
	}

}
