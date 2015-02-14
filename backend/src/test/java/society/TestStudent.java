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
import sut.ac.th.society.domain.Student;
import sut.ac.th.society.repository.StudentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TestStudent {
	@Autowired
	StudentRepository studentrepo;
	
	@Test	
	public void nomalTest(){
		Student student = new Student();
		student.setIdStudent("B5502653");
		student.setFirstname("Worapot");
		student.setSurname("Chaiyut");
		student.setYear((long) 3);
		student.setFaculty("Institute of Engineering");
		student.setDepartment("COMPUTER ENGINEERING");
		studentrepo.save(student);
		assertEquals("B5502653", student.getIdStudent());
		assertEquals("Worapot", student.getFirstname());
		assertEquals("Chaiyut", student.getSurname());
		assertEquals(new Long(3), student.getYear());
		assertEquals("Institute of Engineering", student.getFaculty());
		assertEquals("COMPUTER ENGINEERING", student.getDepartment());
		
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testIdStudentNull(){
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		Student student = new Student();
		student.setFirstname("Worapot");
		student.setSurname("Chaiyut");
		student.setYear((long) 3);
		student.setFaculty("Institute of Engineering ");
		student.setDepartment("COMPUTER ENGINEERING");
		studentrepo.save(student);
	}
	
	@Test
	public void testIdStudentPattern() {
		
		thrown.expect(javax.validation.ConstraintViolationException.class);
		
		Student student = new Student();
		student.setIdStudent("X5502653");
		student.setFirstname("Worapot");
		student.setSurname("Chaiyut");
		student.setYear((long) 3);
		student.setFaculty("Institute of Engineering ");
		student.setDepartment("COMPUTER ENGINEERING");
		studentrepo.save(student);
	}
	
	
	
	@Test
	public void testIdStudentDigitsOnly() {
		
		thrown.expect(javax.validation.ConstraintViolationException.class);
		
		Student student = new Student();
		student.setIdStudent("B5502XXX");
		student.setFirstname("Worapot");
		student.setSurname("Chaiyut");
		student.setYear((long) 3);
		student.setFaculty("Institute of Engineering ");
		student.setDepartment("COMPUTER ENGINEERING");
		studentrepo.save(student);
	}
	
	@Test
	public void yearBoundaries(){
		thrown.expect(javax.validation.ConstraintViolationException.class);
		
		Student student = new Student();
		student.setYear((long) 0);
		studentrepo.save(student);
		Student student2 = new Student();
		student2.setYear((long) 6);
		studentrepo.save(student2);
	}
	
	@Test
	public void testIdStudentAtBoundaries() {
		thrown.expect(javax.validation.ConstraintViolationException.class);
		Student student = new Student();
		student.setIdStudent("B550265333");
		studentrepo.save(student);
		
		Student student2 = new Student();
		student2.setIdStudent("B555");
		studentrepo.save(student2);
		
	}
	
	
	@Test
	public void testStudentUnique() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);

		Student student = new Student();
		student.setIdStudent("B5502653");
		student.setFirstname("Worapot");
		student.setSurname("Chaiyut");
		student.setYear((long) 3);
		student.setFaculty("Institute of Engineering ");
		student.setDepartment("COMPUTER ENGINEERING");
		studentrepo.save(student);

		Student student2 = new Student();
		student2.setIdStudent("B5502653");
		student2.setFirstname("Somchai");
		student2.setSurname("Jaidee");
		student2.setYear((long) 3);
		student2.setFaculty("Institute of Engineering ");
		student2.setDepartment("COMPUTER ENGINEERING");
		studentrepo.save(student2);
	}
	
	@Test
	public void testFirstnameNull(){
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		Student student = new Student();
		student.setIdStudent("B5502653");
		student.setSurname("Chaiyut");
		student.setYear((long) 3);
		student.setFaculty("Institute of Engineering ");
		student.setDepartment("COMPUTER ENGINEERING");
		studentrepo.save(student);
	}
	
	@Test
	public void testSurnameNull(){
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		Student student = new Student();
		student.setIdStudent("B5502653");
		student.setFirstname("Worapot");
		student.setYear((long) 3);
		student.setFaculty("Institute of Engineering ");
		student.setDepartment("COMPUTER ENGINEERING");
		studentrepo.save(student);
	}
	
	@Test
	public void testYearNull(){
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		Student student = new Student();
		student.setIdStudent("B5502653");
		student.setFirstname("Worapot");
		student.setSurname("Chaiyut");
		student.setFaculty("Institute of Engineering ");
		student.setDepartment("COMPUTER ENGINEERING");
		studentrepo.save(student);
	}
	
	
	
	@Test
	public void testFacultyNull(){
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		Student student = new Student();
		student.setIdStudent("B5502653");
		student.setFirstname("Worapot");
		student.setSurname("Chaiyut");
		student.setYear((long) 3);
		student.setDepartment("COMPUTER ENGINEERING");
		studentrepo.save(student);
	}
	
	@Test
	public void testDepartmentNull(){
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		Student student = new Student();
		student.setIdStudent("B5502653");
		student.setFirstname("Worapot");
		student.setSurname("Chaiyut");
		student.setYear((long) 3);
		student.setFaculty("Institute of Engineering ");
		studentrepo.save(student);
	}
	

}
