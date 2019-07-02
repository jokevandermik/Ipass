document.querySelector("#get").addEventListener("click", function () {
	var zoekterm = document.getElementById("zoekterm").value;
	console.log(zoekterm);
	
	let fetchOptions = {
			method: 'GET'
	};
	
	fetch('/restservices/WolfAndCherry/zoekterm/' + zoekterm, fetchOptions)
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
			
			let table = document.querySelector('tabel');
			table.innerHTML = "<table> <thead> <tr> <th>ID</th> <th>Naam</th> <th>Straatnaam</th> <th>Huisnummer</th>"+
			"<th>Postcode</th> <th>Woonplaats</th> <th>Geboortedatum</th> <th>Geslacht</th> <th>Telefoonnummer</th>" +
			"<th>Email</th> <th>Linkedin</th> <th>Eigenschappen</th> <th>Spreektalen</th> <th>Jaren ervaring in IT</th>" +
			"<th>Technische vaardigheden</th> <th>Functionele vaardigheden</th> <th>Werkervaring</th> <th>Computertalen</th>" +
			"<th>Platformen</th> <th>Pakketen</th> </tr> </thead>";
			
			if(myJson == ""){
				let error = document.querySelector('error');
				error.innerHTML = "Er zijn geen profielen die overeenkomen gevonden.";
				table.innerHTML = "";
			}
			
			else{
			
			var i = 0;
			for (i; i < myJson.length; i++) {
				table.innerHTML = table.innerHTML + "<tr>" +
				"<td>"+ myJson[i].id +"</td> <td>"+ myJson[i].naam +"</td> <td>"+ myJson[i].straatnaam +"</td>" +
				"<td>"+ myJson[i].huisnummer +"</td> <td>"+ myJson[i].postcode +"</td> <td>"+ myJson[i].woonplaats +"</td>" +
				"<td>"+ myJson[i].geboortedatum +"</td> <td>"+ myJson[i].geslacht +"</td> <td>"+ myJson[i].telefoonnummer +"</td>" +
				"<td>"+ myJson[i].email +"</td> <td>"+ myJson[i].linkedin +"</td> <td>"+ myJson[i].eigenschappen +"</td>" +
				"<td>"+ myJson[i].spreektalen +"</td> <td>"+ myJson[i].jarenErvaringIT +"</td> <td>"+ myJson[i].technischeVaardigheden +"</td>" +
				"<td>"+ myJson[i].functioneleVaardigheden +"</td> <td>"+ myJson[i].werkervaring +"</td> <td>"+ myJson[i].computertalen +"</td>" +
				"<td>"+ myJson[i].platform +"</td> <td>"+ myJson[i].pakketten +"</td> </table>";
			}
			}
		});
}) 