package society;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sut.ac.th.society.Application;
import sut.ac.th.society.domain.Project;
import sut.ac.th.society.repository.ProjectRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ProjectMoneyTest {
	@Autowired
	private ProjectRepository ProjectRepo;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void TestsNormal() {
		Project p = new Project();
		p.setMoney((long) 5000);
		ProjectRepo.save(p);
		assertEquals(new Long(5000), p.getMoney());
	}
	
	@Test
	public void TestsMoneyNull() {
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		Project p = new Project();
		ProjectRepo.save(p);
	}
	
	@Test
	public void TestsMoneyminus() {
		thrown.expect(javax.validation.ConstraintViolationException.class);
		
		Project p = new Project();
		p.setMoney((long) -1);
		ProjectRepo.save(p);
	}
	

}