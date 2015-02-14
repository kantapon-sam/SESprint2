package society;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sut.ac.th.society.Application;
import sut.ac.th.society.domain.Applyrule;
import sut.ac.th.society.repository.ApplyRulesRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TestApplyrule {
	@Autowired
	ApplyRulesRepository applyrulerepo;
	
	@Test	
	public void nomaltest(){
		Applyrule applyrule = new Applyrule();
		applyrule.setName("aaa");
		applyrulerepo.save(applyrule);
	}
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test	
	public void testApplyruleNull(){
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		
		Applyrule applyrule = new Applyrule();
		applyrulerepo.save(applyrule);
	}
	
	@Test	
	public void testApplyruleLength(){
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		
		Applyrule applyrule = new Applyrule();
		applyrule.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		applyrulerepo.save(applyrule);
	}
	
	
}
