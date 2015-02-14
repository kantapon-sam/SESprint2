package sut.ac.th.society.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sut.ac.th.society.domain.Club;
import sut.ac.th.society.domain.Comment;




@Repository
public interface StatusRepository extends CrudRepository<Comment, Long>{
	public List<Comment> findByClub(Club id);
}
