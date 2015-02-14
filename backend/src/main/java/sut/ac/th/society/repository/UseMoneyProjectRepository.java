package sut.ac.th.society.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sut.ac.th.society.domain.UseMoneyProject;



public interface UseMoneyProjectRepository extends CrudRepository<UseMoneyProject, Long>{


	List<UseMoneyProject> findByProjectMoney(UseMoneyProject findOne);

}
