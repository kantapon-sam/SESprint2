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
import sut.ac.th.society.domain.Club;
import sut.ac.th.society.repository.ClubRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ClubTests {
	@Autowired
	private ClubRepository clubRepo;

	@Test
	public void TestsNormal() {
		Club c = new Club();
		c.setUserName("abcdefg");
		c.setName("กันตภณ");
		c.setLastName("สามทอง");
		c.setPassWord("abcde");
		c.setLevel("ประธานชมรม");
		c.setNameclub("ชมรมคอมพิวเตอร์");
		c.setDescription("Software");
		c.setPlace("ส่วนกืจ");
		c.setAdvisor("อ.ชาญวิทย์");
		c.setAmount((long) 3);
		c.setRegister((long) 0);
		clubRepo.save(c);
		assertEquals("abcdefg", c.getUserName());
		assertEquals("กันตภณ", c.getName());
		assertEquals("สามทอง", c.getLastName());
		assertEquals("abcde", c.getPassWord());
		assertEquals("ประธานชมรม", c.getLevel());
		assertEquals("ชมรมคอมพิวเตอร์", c.getNameclub());
		assertEquals("Software", c.getDescription());
		assertEquals("ส่วนกืจ", c.getPlace());
		assertEquals("อ.ชาญวิทย์", c.getAdvisor());
		assertEquals(new Long(3), c.getAmount());
		assertEquals(new Long(0), c.getRegister());

	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();


	@Test
	public void TestsUserAndPassword() {
		thrown.expect(javax.validation.ConstraintViolationException.class);
		Club c = new Club();
		c.setUserName("abcd");
		c.setPassWord("abcdefghijklmnpq");
		clubRepo.save(c);

	}

	@Test
	public void TestsNull() {
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		Club c = new Club();
		clubRepo.save(c);

	}

	@Test
	public void TestsLevel() {
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		Club c = new Club();
		c.setLevel("ประธานอื่นๆ");
		clubRepo.save(c);

	}

	@Test
	public void TestsAmount() {
		thrown.expect(javax.validation.ConstraintViolationException.class);
		Club c = new Club();
		c.setAmount((long) 0);
		clubRepo.save(c);

	}

}
