package sut.ac.th.society.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sut.ac.th.society.domain.Studentorganization;

public interface StudentorganizationRepository extends CrudRepository<Studentorganization, Long>{
	public List<Studentorganization> findOneById(Long id);
}
