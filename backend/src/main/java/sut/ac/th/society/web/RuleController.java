package sut.ac.th.society.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.society.domain.Rules;
import sut.ac.th.society.repository.RulesRepository;


@RestController
public class RuleController {
	@Autowired
	private RulesRepository repo;
	
	@RequestMapping("/rule/add")
	@ResponseBody
	public void add(@Valid @RequestBody Rules rules){
		repo.save(rules);
		
	}
	
	@RequestMapping("/rule/list")
	@ResponseBody
	public List<Rules> listRule(){
		return (List<Rules>) repo.findAll();
	}
	
	@RequestMapping("/rule/{id}")
	@ResponseBody
	public Rules listByid(@PathVariable("id") Long id){
		return repo.findOne(id);
	}
	
	@RequestMapping("/rule/delete/{id}")
	@ResponseBody
	public void deleteByid(@PathVariable("id") Long id){
		repo.delete(id);
	}
}
