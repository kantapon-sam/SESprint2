package sut.ac.th.society.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import sut.ac.th.society.domain.Project;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	public Project findOne(Long id);
}
