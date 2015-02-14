package sut.ac.th.society.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.society.domain.Studentorganization;
import sut.ac.th.society.repository.StudentorganizationRepository;

@RestController
public class StudenorganizationController {
	@Autowired
	private StudentorganizationRepository orgRepo;
	
	@RequestMapping("/orguser/show")
	@ResponseBody
	public List <Studentorganization> show(){
		return (List<Studentorganization>)orgRepo.findAll();	
	}
	
	@RequestMapping("/orguser/show/{id}")
	@ResponseBody
	public Studentorganization showByid(@PathVariable("id") Long id){
		return orgRepo.findOne(id);
		
	}
	
	@RequestMapping("/orguser/update")
	@ResponseBody
	public void updatepublic(@Valid @RequestBody Studentorganization studentOrganization){
		orgRepo.save(studentOrganization);
		
	}
}
