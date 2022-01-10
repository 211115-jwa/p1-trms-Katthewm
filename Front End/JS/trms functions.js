function getRequestsbyID() 
{
    let response = await fetch("http://localhost:8080/requestor/"+ document.getElementById("getrequestsbox"));
    
    if (response.status === 200) {
        let requests = await response.json();
        showRequests(requests);
    }
}

function createNewRequest() 
{
    let response = await fetch("http://localhost:8080/createrequest"));
    
    if (response.status === 200) {
        let requests = await response.json();
		alert("Created new request");  
        
    }
	else
	{
		alert("Failed to create new request");  
	}
}

function deleteRequest() 
{
    let response = await fetch("http://localhost:8080/delete")+ document.getElementById("deletebyidbox"));
    
    if (response.status === 200) {
        let requests = await response.json();
		alert("Deleted request");  
        
    }
	else
	{
		alert("Failed to delete request");  
	}
}

function acceptRequest() 
{
    let response = await fetch("http://localhost:8080/accept/")+ document.getElementById("acceptbox"));
    
    if (response.status === 200) {
        let requests = await response.json();
		alert("Accepted request");  
        
    }
	else
	{
		alert("Failed to acceept request");  
	}
}

function acceptRequest() 
{
    let response = await fetch("http://localhost:8080/deny/")+ document.getElementById("rejectbox"));
    
    if (response.status === 200) {
        let requests = await response.json();
		alert("Rejected Request request");  
        
    }
	else
	{
		alert("Failed to reject request");  
	}
}




function showRequests(requests) {
    let petsTable = document.getElementById('availablePets');

    // for each pet in the array of pets that we got from the back end
    for (let request of requests) {
        let rowForPet = document.createElement('tr');

        // for each field in the pet (yes, we can iterate through fields)
        for (let field in request) {
            let column = document.createElement('td');
            if (field!=='req_id') {
                column.innerText = pet[field];
            }
            rowForPet.appendChild(column);
        }
        petsTable.appendChild(rowForPet);
    }
}