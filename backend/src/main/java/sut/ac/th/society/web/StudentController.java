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
import sut.ac.th.society.domain.Student;
import sut.ac.th.society.repository.ClubRepository;
import sut.ac.th.society.repository.StudentRepository;



@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentrepo;

	@Autowired
	private ClubRepository clubrepo;
	
	@RequestMapping("/student/show")
	@ResponseBody
	public List <Student> show(){
		return (List<Student>)studentrepo.findAll();
	}

	@RequestMapping("/student/delete/{id}")
	@ResponseBody
	public void deletenamestudent(@PathVariable("id") Long id){
		studentrepo.delete(id);
	}

	@RequestMapping("/student/show/{id}")
	@ResponseBody
	public Student showid(@PathVariable("id") Long id){
		return studentrepo.findOne(id);
		
	}
	
	@RequestMapping("/student/show/member/{club_id}")
	@ResponseBody
	public List<Student> showMember(@PathVariable("club_id") Long id){
		return (List<Student>)studentrepo.findByClub(clubrepo.findOne(id));
	}

	@RequestMapping("/student/add/{id}")
	@ResponseBody
	public void add(@PathVariable("id") Long id,@Valid @RequestBody Student student){
		Club club = clubrepo.findOne(id);
		club.setRegister(club.getRegister() + 1);
		clubrepo.save(club);
		student.setClub(club);
		studentrepo.save(student);
	}
	
	@RequestMapping("/showclub")
	@ResponseBody
	public List<Club> showclub(){
		return (List<Club>) clubrepo.findAll();	
	}
	
	@RequestMapping("/showclubdetail/{id}")
	@ResponseBody
	public List<Club> show2(@PathVariable("id") Long id){
		return(List<Club>) clubrepo.findById(id);		
	}
	
	@RequestMapping("/showstudents/{id}")
	@ResponseBody
	public List<Student> showstudents(@PathVariable("id") Long id){
		return(List<Student>) studentrepo.findByClubId(id);		
	}
	
}
