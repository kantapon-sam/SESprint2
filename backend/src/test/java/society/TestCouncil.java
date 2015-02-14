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
import sut.ac.th.society.domain.Council;
import sut.ac.th.society.repository.CouncilRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TestCouncil {
	
	@Autowired
	CouncilRepository councilrepo;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test	
	public void nomalTest(){
		Council council = new Council();
		council.setFirstname("Worapot");
		council.setSurname("Chaiyut");
		council.setUsername("View");
		council.setPassword("1234");
		council.setDateToApply1(new Date(20150101));
		council.setDateToApply2(new Date(20150108));
		council.setDateToCreate1(new Date(20150101));
		council.setDateToCreate2(new Date(20150108));
		council.setLevel("ฝ่ายกิจกรรม");
		councilrepo.save(council);	
		
		assertEquals("Worapot", council.getFirstname());
		assertEquals("Chaiyut", council.getSurname());
		assertEquals("View", council.getUsername());
		assertEquals("1234", council.getPassword());
		assertEquals(new Date(20150101), council.getDateToApply1());
		assertEquals(new Date(20150108), council.getDateToApply2());
		assertEquals(new Date(20150101), council.getDateToCreate1());
		assertEquals(new Date(20150108), council.getDateToCreate2());
		assertEquals("ฝ่ายกิจกรรม", council.getLevel());
		
		
	}
	
	@Test
	public void testdateNull(){
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		Council council = new Council();
		council.setFirstname("Worapot");
		council.setSurname("Chaiyut");
		council.setUsername("View");
		council.setPassword("1234");
		councilrepo.save(council);
	}
}
