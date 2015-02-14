package sut.ac.th.society.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sut.ac.th.society.domain.Report;
@Repository
public interface ReportRepository extends CrudRepository<Report, Long>{

}
