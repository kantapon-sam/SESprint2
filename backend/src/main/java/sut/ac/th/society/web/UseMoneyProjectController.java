package sut.ac.th.society.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sut.ac.th.society.domain.UseMoneyProject;
import sut.ac.th.society.repository.UseMoneyProjectRepository;



@RestController
public class UseMoneyProjectController {
	
	@Autowired
	private UseMoneyProjectRepository testRepo;
	
	
	
	@RequestMapping("/money/add")
	@ResponseBody
	public void testadd(@Valid @RequestBody UseMoneyProject money){
		testRepo.save(money);
	}
	
	@RequestMapping("/money")
	@ResponseBody
	public List<UseMoneyProject> listUseMoneyProject(){
		return (List<UseMoneyProject>) testRepo.findAll();
	}
	
	@RequestMapping("/money/use/{project_id}")
	@ResponseBody
	public List<UseMoneyProject> showMember(@PathVariable("project_id") Long id){
		return (List<UseMoneyProject>)testRepo.findByProjectMoney(testRepo.findOne(id));
	}
	
}