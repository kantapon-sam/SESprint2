package sut.ac.th.society.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.society.domain.Club;
import sut.ac.th.society.domain.Council;
import sut.ac.th.society.repository.ClubRepository;
import sut.ac.th.society.repository.CouncilRepository;

@RestController
public class LoginController {
	@Autowired
	private ClubRepository clubRepo;
	@Autowired
	private CouncilRepository councilRepo;

	@RequestMapping("/chairman/login/{us}/{pw}")
	@ResponseBody
	public Club loginchairman(@PathVariable("us") String userName,
			@PathVariable("pw") String passWord) {
		Club chairman = clubRepo.findByUserNameAndPassWord(userName, passWord);
		return chairman;
	}

	@RequestMapping("/council/login/{us}/{pw}")
	@ResponseBody
	public Council logincouncil(@PathVariable("us") String username,
			@PathVariable("pw") String password) {
		Council council = councilRepo.findByUsernameAndPassword(username,
				password);
		return council;
	}

}