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
		c.setName("�ѹ���");
		c.setLastName("����ͧ");
		c.setPassWord("abcde");
		c.setLevel("��иҹ����");
		c.setNameclub("��������������");
		c.setDescription("Software");
		c.setPlace("��ǹ�ר");
		c.setAdvisor("�.�ҭ�Է��");
		c.setAmount((long) 3);
		c.setRegister((long) 0);
		clubRepo.save(c);
		assertEquals("abcdefg", c.getUserName());
		assertEquals("�ѹ���", c.getName());
		assertEquals("����ͧ", c.getLastName());
		assertEquals("abcde", c.getPassWord());
		assertEquals("��иҹ����", c.getLevel());
		assertEquals("��������������", c.getNameclub());
		assertEquals("Software", c.getDescription());
		assertEquals("��ǹ�ר", c.getPlace());
		assertEquals("�.�ҭ�Է��", c.getAdvisor());
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
		c.setLevel("��иҹ����");
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
