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
import sut.ac.th.society.domain.UseMoneyProject;
import sut.ac.th.society.repository.UseMoneyProjectRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UseMoneyTest {
	@Autowired
	private UseMoneyProjectRepository usemoneyRepo;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void TestsNormal() {
		UseMoneyProject p = new UseMoneyProject();
		p.setMoney((long) 5000);
		p.setUsemoney("ปากกา 5 ด้าม");
		usemoneyRepo.save(p);
		assertEquals(new Long(5000), p.getMoney());
		assertEquals(new String("ปากกา 5 ด้าม"),p.getUsemoney());
	}
	
	@Test
	public void TestsMoneyNull() {
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		UseMoneyProject p = new UseMoneyProject();
		usemoneyRepo.save(p);
	}
	
	@Test
	public void TestsMoneyminus() {
		thrown.expect(javax.validation.ConstraintViolationException.class);
		
		UseMoneyProject p = new UseMoneyProject();
		p.setMoney((long) -1);
		usemoneyRepo.save(p);
	}
	
	

}