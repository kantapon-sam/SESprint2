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
import sut.ac.th.society.domain.Club;
import sut.ac.th.society.domain.Rate;
import sut.ac.th.society.repository.RateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class RateTests {
	@Autowired
	private RateRepository rateRepo;

	@Test
	public void TestNormal() {
		Rate r = new Rate();
		r.setPoint1((long) 3);
		r.setPoint2((long) 2);
		r.setPoint3((long) 3);
		r.setPoint4((long) 1);
		r.setPoint5((long) 2);
		r.setScore((long) 15);
		Club c = new Club();
		c.setId((long) 20);
		r.setClub(c);
		rateRepo.save(r);
		assertEquals(new Long(3), r.getPoint1());
		assertEquals(new Long(2), r.getPoint2());
		assertEquals(new Long(3), r.getPoint3());
		assertEquals(new Long(1), r.getPoint4());
		assertEquals(new Long(2), r.getPoint5());
		assertEquals(new Long(15), r.getScore());
		assertEquals(c, r.getClub());

	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void TestDigitMinMax() {
		thrown.expect(javax.validation.ConstraintViolationException.class);
		Rate r = new Rate();
		r.setPoint1((long) 0);
		r.setPoint2((long) 5);
		r.setPoint3((long) 6);
		r.setPoint4((long) 7);
		r.setPoint5((long) 8);
		r.setScore((long) 20);
		rateRepo.save(r);
	}

	@Test
	public void TestNumberNull() {
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		Rate r = new Rate();
		rateRepo.save(r);
	}

}
