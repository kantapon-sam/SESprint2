package sut.ac.th.society.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sut.ac.th.society.domain.Council;

@Repository
public interface CouncilRepository extends CrudRepository<Council, Long>{
	public  List<Council> findOneById(Long id);
	public Council findByUsernameAndPassword(String username, String password);
}
