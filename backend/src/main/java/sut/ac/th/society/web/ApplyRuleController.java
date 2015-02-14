package sut.ac.th.society.web;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.society.domain.Applyrule;
import sut.ac.th.society.repository.ApplyRulesRepository;


@RestController
public class ApplyRuleController {
	@Autowired
	private ApplyRulesRepository rulerepo;
	
	@RequestMapping("/applyrule/add")
	@ResponseBody
	public String add(@Valid @RequestBody Applyrule rules){
		rulerepo.save(rules);
		return "เพิ่มกฎการสมัครชมรมเรียบร้อยแล้ว";
	}
	
	@RequestMapping("/applyrule/list")
	@ResponseBody
	public List<Applyrule> listRule(){
		return (List<Applyrule>) rulerepo.findAll();
	}
	
	@RequestMapping("/applyrule/{id}")
	@ResponseBody
	public Applyrule listByid(@PathVariable("id") Long id){
		return rulerepo.findOne(id);
	}
	
	@RequestMapping("/applyrule/delete/{id}")
	@ResponseBody
	public String deleteByid(@PathVariable("id") Long id){
		rulerepo.delete(id);
		return "ลบกฎการสมัครชมรมเรียบร้อยแล้ว";
	}
	
}
