package society;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




import sut.ac.th.society.Application;
import sut.ac.th.society.domain.Event;
import sut.ac.th.society.repository.EventRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class EventTests {
	
	@Autowired
	private EventRepository eventRepo;
	
	@Test
	public void TestsNormal(){
		Event ev = new Event();
		ev.setClub("gfdgdffdhdfh");
		ev.setMessage("sdrwefsdfcs");
		ev.setDate(new Date(20151213));
		eventRepo.save(ev);
		assertEquals("gfdgdffdhdfh", ev.getClub());
		assertEquals("sdrwefsdfcs", ev.getMessage());
		assertEquals(new Date(20151213), ev.getDate());
	}
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void TestsNull() {
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		Event ev1 = new Event();
		eventRepo.save(ev1);
	}
	@Test
	public void TestsClubAndMessage() {
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		Event ev2 = new Event();
		ev2.setClub("abcdgabcdgabcdgabcdg");
		ev2.setMessage("abcdgabcdgabcdgabcdgabcdgabcdgabcdgabcdg");
		eventRepo.save(ev2);

	}

}
