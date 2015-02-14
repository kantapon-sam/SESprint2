package sut.ac.th.society.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import sut.ac.th.society.domain.Club;
import sut.ac.th.society.domain.Rate;

public interface RateRepository extends CrudRepository<Rate, Long> {

	public Rate findOne(Long id);

	public List<Rate> findByClubId(Club id);

	public List<Rate> findById(Long id);

	public List<Rate> findByClub(Club id);

}
