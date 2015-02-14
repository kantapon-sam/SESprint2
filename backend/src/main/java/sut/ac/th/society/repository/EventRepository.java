package sut.ac.th.society.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sut.ac.th.society.domain.Event;



@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	
}
