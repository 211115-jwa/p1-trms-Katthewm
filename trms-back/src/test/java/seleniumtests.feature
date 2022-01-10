Feature: Tuition Reimbursement Approval Management System

	Scenario Outline: User submits a request
	
		Given The user is on the site
		When The user copies in the example string and modifies it
		Then Create a new request when the user clicks submit
		
		EXAMPLE CREATE:{ "reqId": 3, "requestor": { "empId": 1, "firstName": "Matthew", "lastName": "Kelley", "username": "Katthewm", "password": "12345", "role": { "roleId": 1, "name": "Employee" }, "funds": 1000.0, "supervisor": { "empId": 5, "firstName": null, "lastName": null, "username": null, "password": null, "role": null, "funds": 0.0, "supervisor": null, "department": null }, "department": { "deptId": 3, "name": "", "deptHeadId": 0 } }, "eventDate": [ 2022, 1, 3 ], "eventTime": [ 8, 3, 4 ], "location": null, "description": null, "cost": 0.0, "gradingFormat": { "formatId": 1, "name": null, "example": "exam" }, "eventType": { "eventId": 1, "name": "testing", "percentCovered": 0.0 }, "status": { "statusId": 1, "name": "started", "approver": null }, "submittedAt": [ 2022, 1, 5, 22, 38, 20, 440000000 ] }
	
	Scenario Outline: Getting the users current requests
	
		Given The user is on the site
		When The user inputs their id
		Then Get the requests according to the inputted id 
		
		Feature: Tuition Reimbursement Approval Management System
		Examples:
		|		id:1		|		output:requests from user 1		|
		|		id:2			|		output:requests from user 2				|
	
	Scenario Outline: Approving the request
	
		Given the selected request is waiting for approval/denial
		When The supervisor selects the request
		Then Approve the request when the button is clicked	
		Examples:
		|		req_id=1		|		Accepted		|
		|		req_id=2			|		in_progress				|
		|		req_id=3				|		Denied				|
	
	Scenario Outline: Denying the request
	
		Given the selected request is waiting for approval/denial
		When The supervisor selects the request
		Then Deny the request when the button is clicked	
		Examples:
		|		req_id=1		|		Accepted		|
		|		req_id=2			|		in_progress				|
		|		req_id=3				|		Denied				|
	
	
	Scenario: Deleting Request
	
		Given the user has submitted requests
		When The user selects a request
		Then Delete the request
		Examples:
		|		req_id=1		|		Delete		|
