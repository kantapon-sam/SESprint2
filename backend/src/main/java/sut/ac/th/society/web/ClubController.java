package sut.ac.th.society.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.society.domain.Club;
import sut.ac.th.society.repository.ClubRepository;





@RestController
public class ClubController {
	@Autowired
	private ClubRepository clu;
	
	@RequestMapping("/club/show")
	@ResponseBody
	public List <Club> show(){
		return (List<Club>)clu.findAll();	
	}
	@RequestMapping("/club/show/{id}")
	@ResponseBody
	public Club showid(@PathVariable("id") Long id){
		return clu.findOne(id);
		
	}
	@RequestMapping("/club/show/user/{user_id}")
	@ResponseBody
	public Club showMember(@PathVariable("user_id") Long id){
		return clu.findOne(id);
	}
	@RequestMapping("/club/update")
	@ResponseBody
	public void updatepublic(@Valid @RequestBody Club club){
		clu.save(club);
		
	}
	@RequestMapping("/club/delete/{id}")
	@ResponseBody
	public void deleteclub(@PathVariable("id") Long id){
		clu.delete(id);
	}
	@RequestMapping("/club/add")
	@ResponseBody
	public void addclub(@Valid @RequestBody Club club){
		clu.save(club);
	}
	
}
