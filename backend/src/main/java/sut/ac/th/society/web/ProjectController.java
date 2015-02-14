package sut.ac.th.society.web;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.society.domain.Club;
import sut.ac.th.society.domain.Project;
import sut.ac.th.society.repository.ClubRepository;
import sut.ac.th.society.repository.ProjectRepository;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectrepo;
	
	@Autowired
	private ClubRepository clubrepo;
	
	@RequestMapping("/money/add/{id}")
	@ResponseBody
	public String testadd(@PathVariable("id") Long id,@Valid @RequestBody Project money){
		Club club = clubrepo.findOne(id);
		money.setClub(club);
		projectrepo.save(money);
		return "Add OK";
	}
	
	@RequestMapping("show/money/{id}")
	@ResponseBody
	public Project showmoney(@PathVariable("id") Long id){
		return projectrepo.findOne(id);
		
	}

}
