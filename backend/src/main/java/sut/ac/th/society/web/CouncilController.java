package sut.ac.th.society.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.society.repository.CouncilRepository;
import sut.ac.th.society.domain.Council;

@RestController
public class CouncilController {
	
	@Autowired
	private CouncilRepository councilrepo;
	
	@RequestMapping("/show/date/{id}")
	@ResponseBody
	public List<Council> showDate(@PathVariable("id") Long id) {
		return (List<Council>) councilrepo.findOneById(id);
	}
	
	@RequestMapping("/save/date")
	@ResponseBody
	public String saveDate(@Valid @RequestBody Council council){
		councilrepo.save(council);
		return "แก้ไขเรียบร้อยแล้ว";
	}
	

}
