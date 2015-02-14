package sut.ac.th.society.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sut.ac.th.society.domain.Club;
import sut.ac.th.society.domain.Student;



@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

	public Student findOne(Long id);
	
	public List<Student> findByClub(Club club);
	public List<Student> findById(Long id);
	public List<Student> findByClubId(Long id);
}
