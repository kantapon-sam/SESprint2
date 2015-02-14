package sut.ac.th.society.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sut.ac.th.society.domain.Club;





@Repository
public interface ClubRepository extends CrudRepository<Club, Long>{
	
	public List<Club> findById(Long id);

	public Club findOne(Long id);

	
	public Club findByUserNameAndPassWord(String userName, String passWord);

	

	

	
	
	
	
	
}
