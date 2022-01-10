package com.revature.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.revature.beans.Comment;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.beans.Status;
import com.revature.data.CommentDAO;
import com.revature.data.EmployeeDAO;
import com.revature.data.EventTypeDAO;
import com.revature.data.GradingFormatDAO;
import com.revature.data.ReimbursementDAO;
import com.revature.data.StatusDAO;
import com.revature.utils.DAOFactory;

public class RequestReviewServiceImpl implements RequestReviewService {
	private EventTypeDAO eventTypeDao = DAOFactory.getEventTypeDAO();
	private GradingFormatDAO gradFormatDao = DAOFactory.getGradingFormatDAO();
	private StatusDAO statusDao = DAOFactory.getStatusDAO();
	private ReimbursementDAO reqDao = DAOFactory.getReimbursementDAO();
	private CommentDAO commentDao = DAOFactory.getCommentDAO();
	private EmployeeDAO empDao = DAOFactory.getEmployeeDAO();
	
	@Override
	public Set<Reimbursement> getPendingReimbursements(Employee approver) {
		//Set<Reimbursement> reimbursement = reqDao.getById(requestor);
		return null;
	}
	@Override
	public void approveRequest(Reimbursement request) 
	{
		
		if(request.getStatus().getStatusId()==2)
		{
			request.getStatus().setStatusId(1);
			System.out.println("Approved");
		}
		
		reqDao.update(request);
		
	}
	@Override
	public void rejectRequest(Reimbursement request) {
		System.out.println(request.getStatus().getStatusId());
		if(request.getStatus().getStatusId()==1)
		{
			request.getStatus().setStatusId(0);
			System.out.println("Denied");
		}

		reqDao.update(request);
		System.out.println("update?");
	}
	@Override
	public void rejectRequest(Reimbursement request, Comment comment) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void grade(Reimbursement request, Comment comment) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Reimbursement getById(int requestorId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Reimbursement delete(Reimbursement request) {
		reqDao.delete(request);
		return null;
	}
	@Override
	public Set<Reimbursement> getallemployees() 
	{
		return reqDao.getallemployees();
	}

}
