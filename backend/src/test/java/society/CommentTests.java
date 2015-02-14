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
import sut.ac.th.society.domain.Comment;
import sut.ac.th.society.repository.StatusRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CommentTests {
		
	@Autowired
    private StatusRepository statusRepository;
 
 @Test
	public void TestsNormal() {
		Comment com = new Comment();
		com.setComment("sdasdfd");
		statusRepository.save(com);
		assertEquals("sdasdfd", com.getComment());

	}

 @Rule
    public ExpectedException thrown = ExpectedException.none();
 

    @Test
    public void TestsComment() {
        
    	thrown.expect(javax.validation.ConstraintViolationException.class);

        Comment com1 = new Comment();
        com1.setComment("asdf");
        com1 = statusRepository.save(com1);

        Comment com2 = new Comment();
        com2.setComment("asdfgasdfgasdfgasdfgasdfgasdfgasdfgasdfgq");
        com2 = statusRepository.save(com2);
    }
}
