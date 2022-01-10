

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.data.ReimbursementDAO;
import com.revature.data.postgres.ReimbursementPostgres;

public interface ReimbursementDAOTest 
{
	Reimbursement testsample = new Reimbursement();
	ReimbursementDAO reimbursementDao = new ReimbursementPostgres();
	

	@Test
	public static void createTest() 
	{
		Reimbursement testsample = new Reimbursement();
		testsample.setReqId(9999);
		assertNotNull(testsample);
	}


	@Test
	public static void testUpdatepositive() 
	{
		Reimbursement testsample = new Reimbursement();
		testsample.setReqId(9999);
		reimbursementDao.update(testsample);
		assertEquals(12345,testsample.getReqId());	
	}
	
	@Test
	public static void testUpdatenegative() 
	{
		Reimbursement testsample = new Reimbursement();
		testsample.setReqId(9999);
		reimbursementDao.update(testsample);
		assertEquals(12345,testsample.getReqId());	
	}

	@Test
	public static void getbyIDnegative()
	{
		Reimbursement testsample = new Reimbursement();
		testsample.setReqId(9999);
		assertEquals(12345, testsample.getReqId());
	}
	
	@Test
	public static void getbyIDpositive()
	{
		Reimbursement testsample = new Reimbursement();
		testsample.setReqId(9999);
		assertEquals(9999, testsample.getReqId());
	}
	
	@Test
	public static void getAll() 
	{
		Set<Reimbursement> givenOutput = reimbursementDao.getAll();
		assertNotNull(givenOutput);
	}

}
