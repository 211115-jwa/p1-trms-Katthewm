

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.data.EmployeeDAO;
import com.revature.data.postgres.EmployeePostgres;

public interface EmployeeDAOTest {
	EmployeeDAO employeeDao = new EmployeePostgres();

	@Test
	public static void createTestpositive() 
	{
		Employee testsample = new Employee();
		assertNotNull(testsample);
	}

	
	@Test
	public static void getbyidpositive() {
		Employee testsample = new Employee();
		testsample.setEmpId(9999);
		assertEquals(9999,testsample.getEmpId());	
	}
}