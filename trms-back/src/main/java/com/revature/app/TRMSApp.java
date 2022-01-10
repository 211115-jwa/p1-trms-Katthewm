package com.revature.app;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;

import static io.javalin.apibuilder.ApiBuilder.*;

import com.revature.controllers.RequestsController;

public class TRMSApp {

	public static void main(String[] args) {
		Javalin app = Javalin.create().start();
		
		app.routes(() -> 
		{
			//get requests by emp id
			path("/requestor/{id}", () -> {
				get(RequestsController::getRequestsByRequestor);
			});
			//creates a request off of an inputted string
			path("/createrequest", () -> 
			{
				post(RequestsController::submitReimbursementRequest);
				//put(RequestsController::createRequest);
			});
			//accepts the request
			path("/accept/{id}", () -> 
			{
				put(RequestsController::acceptRequest);
			});
			
			//rejects the request
			path("/deny/{id}", () -> 
			{
				put(RequestsController::rejectRequest);
			});
			//rejects the request with comment????
			path("/deny2/{id}", () -> 
			{
				put(RequestsController::rejectRequest2);
			});
			
			//employee inputs grades
			path("/inputgrades/{id}", () -> 
			{
				//put(RequestsController::adoptPet);
			});
			//grades the work
			path("/grade/{id}", () -> 
			{
				//put(RequestsController::grade);
			});
			
			//gets comments
			path("/getcomments", () -> {
				put(RequestsController::getComments);
			});
			//adds comments
			path("/getcomments/{id}", () -> {
				put(RequestsController::addcomment);
			});
			//delete request
			path("/delete/{id}", () -> {
				delete(RequestsController::delete);
			});
			//get employees
			path("/getemployees", () -> {
				get(RequestsController::getemployees);
			});
		});
	}
}
