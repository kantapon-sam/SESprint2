package sut.ac.th.society.web;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sut.ac.th.society.domain.Rate;
import sut.ac.th.society.repository.ClubRepository;
import sut.ac.th.society.repository.RateRepository;

@RestController
public class RateController {

	@Autowired
	private RateRepository rate;
	@Autowired
	private ClubRepository clu;

	@RequestMapping("/rate/show/{id}")
	@ResponseBody
	public List<Rate> showrateid(@PathVariable("id") Long id) {
		return (List<Rate>) rate.findByClub(clu.findOne(id));
	}

	@RequestMapping("/rate/add/{id}")
	@ResponseBody
	public void add(@Valid @RequestBody Rate rate, @PathVariable("id") Long id) {
		rate.setClub(clu.findOne(id));
		this.rate.save(rate);
	}

}
