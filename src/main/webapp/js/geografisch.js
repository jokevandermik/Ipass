//commando om te wachten tot er wordt gedrukt op de button in de Geografisch.html
document.querySelector("#get").addEventListener("click", function () {
	var pcode = document.getElementById("geografisch").value;
	console.log(pcode);
	
	let fetchOptions = {
			method: 'GET'
	};
	//roept webservice aan om profielen met opgegeven postcode op te halen
	fetch('/restservices/WolfAndCherry/geografisch/' + pcode, fetchOptions)
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
			
			let jsonPostcode = document.querySelector('postcode');
			jsonPostcode.innerHTML = ""
			
			let table = document.querySelector('tbody');
			table.innerHTML = "";
			
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
				"<td>"+ myJson[i].platform +"</td> <td>"+ myJson[i].pakketten +"</td>";
			}
			
			jsonPostcode.innerHTML = jsonPostcode.innerHTML + "<iframe width=\"100%\" height=\"600\" src=\"https://maps.google.com/maps?width=90%&height=600&hl=nl&q="+ myJson[0].postcode +"%2C%20Netherlands+(Mijn%20bedrijfsnaam)&ie=UTF8&t=&z=14&iwloc=B&output=embed\" frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" margin-left=\"100px\">" +
			"<a href=\"https://www.mapsdirections.info/nl/maak-een-google-map/\">Maak een Google Map</a> van <a href=\"https://www.mapsdirections.info/nl/\">Nederland Kaart</a>" +
			"</iframe>";
			}
		});
})