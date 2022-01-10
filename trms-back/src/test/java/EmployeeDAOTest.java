

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.revature.beans.Employee;
import com.revature.data.EmployeeDAO;
import com.revature.data.postgres.EmployeePostgres;

public interface EmployeeDAOTest {
	EmployeeDAO employeeDao = new EmployeePostgres();

	@Test
	public static void createTest() {
		Employee create = new Employee();
		assertNotEquals(0, employeeDao.create(create));
	}

	@Test
	public static void testNotValidId() {
		Employee employeeOutput= employeeDao.getById(10000);
		assertNull(employeeOutput);
	}
	
	@Test
	public static void testUpdate() {
		Employee personUp = employeeDao.getById(1);
		personUp.setFirstName("Boss");
		employeeDao.update(personUp);
		assertEquals("Boss",employeeDao.getById(1).getFirstName());	
	}
	
	@Test
	public static void getValidPersonById()
	{
		String expectedUsername = "BruWill123";
		Employee actual = employeeDao.getById(1);
		assertEquals(expectedUsername, actual.getUsername());
	}
	
	@Test
	public static void getByUsernameWhenUsernameExists() {
		String usernameInput = "BruWill123";
		Employee employeeOutput = employeeDao.getByUsername(usernameInput);
		assertEquals("BruWill123", employeeOutput.getUsername());
	}
	
	@Test
	public static void getByUsernameButUsernameDoesNotExist() {
		String usernameInput = "qwertyuiop";
		Employee employeeOutput = employeeDao.getByUsername(usernameInput);
		assertNull(employeeOutput); 
	}
	
	@Test
	public static void getAll() {
		Set<Employee> givenOutput = employeeDao.getAll();
		assertNotNull(givenOutput);
	}

}
