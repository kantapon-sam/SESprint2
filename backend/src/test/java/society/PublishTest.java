package society;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sut.ac.th.society.Application;
import sut.ac.th.society.domain.Studentorganization;
import sut.ac.th.society.repository.StudentorganizationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PublishTest {
	@Autowired
	private StudentorganizationRepository orgRepo;
	
	@Test
	public void TestNormal() {
		Studentorganization org = new Studentorganization();
		org.setPublishsubscribe("ว่าง");
		orgRepo.save(org);
		assertEquals("ว่าง", org.getPublishsubscribe());

	}
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	
	@Test
	public void TestPublishNull() {
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		Studentorganization org = new Studentorganization();
		orgRepo.save(org);
	}
}

