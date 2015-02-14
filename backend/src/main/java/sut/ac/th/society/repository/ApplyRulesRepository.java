package sut.ac.th.society.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sut.ac.th.society.domain.Applyrule;

@Repository
public interface ApplyRulesRepository extends CrudRepository<Applyrule, Long>{

}
