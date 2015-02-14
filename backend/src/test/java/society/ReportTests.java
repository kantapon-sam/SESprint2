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
import sut.ac.th.society.domain.Report;
import sut.ac.th.society.repository.ReportRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ReportTests {
	@Autowired
	private ReportRepository ReportRepository;

	@Test
	public void testNormal() {
		Report r = new Report();
		r.setName("Abcd3");
		ReportRepository.save(r);

		assertEquals("Abcd3", r.getName());
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testNameNull() {
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		Report r = new Report();
		ReportRepository.save(r);

	}

	@Test
	public void testNameLength() {
		thrown.expect(javax.validation.ConstraintViolationException.class);
		Report r1 = new Report();
		r1.setName("A123");
		ReportRepository.save(r1);

	}

}
