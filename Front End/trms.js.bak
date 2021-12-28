getPets();
//getPetsAjax();

async function getPets() {
    let response = await fetch('http://localhost:8080/pets');
    // let response = await fetch('http://localhost:8080/pets/8',{method:'PUT', body:JSON.stringify(petObj)});
    
    if (response.status === 200) {
        let pets = await response.json();
        console.log(pets);
        showPets(pets);
    }
}

function getPetsAjax() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = getData;
    xhr.open('GET', 'http://localhost:8080/pets');
    xhr.send();

    function getData() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let response = xhr.responseText;
                let pets = JSON.parse(response);
                showPets(pets);
            }
        }
    }
}

function showPets(pets) {
    let petsTable = document.getElementById('availablePets');

    // for each pet in the array of pets that we got from the back end
    for (let pet of pets) {
        let rowForPet = document.createElement('tr');

        // for each field in the pet (yes, we can iterate through fields)
        for (let field in pet) {
            let column = document.createElement('td');
            if (field!=='status') {
                // pet[field] gets the value of the field
                column.innerText = pet[field];
            } else {
                column.innerHTML=`<button id="adopt${pet.petId}">Adopt</button>`;
            }
            rowForPet.appendChild(column);
        }
        petsTable.appendChild(rowForPet);
    }
}