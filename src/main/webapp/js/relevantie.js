//commando om te wachten tot er wordt gedrukt op de button in de Relevantie.html
document.querySelector("#get").addEventListener("click", function () {
	var lijst = document.getElementById("relevant");
	var relevantie = lijst.options[lijst.selectedIndex].value;
	console.log(relevantie)
	
	let fetchOptions = {
			method: 'GET'
	};
	
	//Roept webservice aan met opgegeven relevantie uitkeuzelijst
	fetch('/restservices/WolfAndCherry/relevantie/' + relevantie, fetchOptions)
		.then((response) => {
			console.log(response.status);
			if (response.status = 200){
				hoi = "response oke";
				console.log(hoi);
				return response.json();
			}
			else if(response.status = 403){
			hoi = "status  403";
			console.log(hoi);
			
			}
			else {
				hoi = "de rest";
				console.log(hoi);
				console.log(response.status);
			}
		})
		.then((myJson) => {
			console.log(JSON.stringify(myJson));
			
			let table = document.querySelector('tbody');
			table.innerHTML = "";
			
			if(myJson == ""){
				let error = document.querySelector('error');
				error.innerHTML = "Er zijn geen profielen die overeenkomen gevonden.";
				table.innerHTML = "";
			}
			
			else{
			
			//zet profielen in een tabel op het scherm
			var i = 0;
			for (i; i < myJson.length; i++) {
				table.innerHTML = table.innerHTML + "<tr>" +
				"<td>"+ myJson[i].id +"</td> <td>"+ myJson[i].naam +"</td> <td>"+ myJson[i].straatnaam +"</td>" +
				"<td>"+ myJson[i].huisnummer +"</td> <td>"+ myJson[i].postcode +"</td> <td>"+ myJson[i].woonplaats +"</td>" +
				"<td>"+ myJson[i].geboortedatum +"</td> <td>"+ myJson[i].geslacht +"</td> <td>"+ myJson[i].telefoonnummer +"</td>" +
				"<td>"+ myJson[i].email +"</td> <td>"+ myJson[i].linkedin +"</td> <td>"+ myJson[i].eigenschappen +"</td>" +
				"<td>"+ myJson[i].spreektalen +"</td> <td>"+ myJson[i].jarenErvaringIT +"</td> <td>"+ myJson[i].technischeVaardigheden +"</td>" +
				"<td>"+ myJson[i].functioneleVaardigheden +"</td> <td>"+ myJson[i].werkervaring +"</td> <td>"+ myJson[i].computertalen +"</td>" +
				"<td>"+ myJson[i].platform +"</td> <td>"+ myJson[i].pakketten +"</td>";
			}
			}
		});
})