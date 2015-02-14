package sut.ac.th.society.web;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.society.domain.Report;
import sut.ac.th.society.repository.ReportRepository;
@RestController
public class ReportController {
	@Autowired
	private ReportRepository repo;
	
	@RequestMapping("/report/add")
	@ResponseBody
	public void add(@Valid @RequestBody Report report){
		repo.save(report);
		
	}
	@RequestMapping("/report/list")
	@ResponseBody
	public List<Report> listRule(){
		return (List<Report>) repo.findAll();
	}
	
	@RequestMapping("/report/{id}")
	@ResponseBody
	public Report listByid(@PathVariable("id") Long id){
		return repo.findOne(id);
	}
	
	@RequestMapping("/report/delete/{id}")
	@ResponseBody
	public void deleteByid(@PathVariable("id") Long id){
		repo.delete(id);
	}
}
