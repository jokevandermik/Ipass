document.querySelector("#ophalen").addEventListener("click", function () {
	var idinput = document.getElementById("id").value;
	console.log(idinput)
	
	var json;
	
	let fetchOptions = {
			method: 'GET'
	};
	
	fetch('/restservices/WolfAndCherry/aanpassen/' + idinput, fetchOptions)
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
			
//			var parts = myJson[0].geboortedatum.split('-');
//			var gbdatum = new Date (parts[2], parts[1] -1, parts[0]);
//			console.log(gbdatum);
			
			var tel = myJson[0].telefoonnummer;
			var telnr = Number(tel);
			console.log(telnr);
			var huis = myJson[0].huisnummer;
			var huisnr = Number(huis);
			var jaren = myJson[0].jarenErvaringIT
			var jarenIT = Number(jaren);

			let input = document.querySelector('inputData');
			input.innerHTML = "<div class=\"div_input_links\">" +
				"Naam: <input class=\"input\" type=\"text\" name=\"naam\" value=\"" + myJson[0].naam + "\" maxlength=\"50\"/><br>" + 
				"Straatnaam: <input class=\"input\" type=\"text\" name=\"straatnaam\" value=\" "+ myJson[0].straatnaam +"\" maxlength=\"50\"/><br>" + 
				"Woonplaats: <input class=\"input\" type=\"text\" name=\"woonplaats\" value=\" "+ myJson[0].woonplaats +"\" maxlength=\"50\"/><br>" + 
				"Geboortedatum: <input class=\"input\" type=\"text\" name=\"geboortedatum\" value=\" "+ myJson[0].geboortedatum +"\"/><br>" +
				"Telefoonnummer: <input class=\"input\" type=\"number\" name=\"telefoonnummer\" value= "+ telnr +" maxlength=\"10\"/><br>" +
				"<br>" + 
				"Eigenschappen: <input class=\"input\" type=\"text\" name=\"eigenschappen\" value=\" "+ myJson[0].eigenschappen +"\" maxlength=\"256\"/><br>" +
				"Spreektalen: <input class=\"input\" type=\"text\" name=\"spreektalen\" value=\" "+ myJson[0].spreektalen +"\" maxlength=\"256\"/><br>" +
				"Jaren ervaring in IT: <input class=\"input\" type=\"number\" name=\"jaren_ervaring_it\" value= "+ jarenIT +" maxlength=\"5\"/><br>" +
				"<br>" +
				"Technische vaardigheden: <input class=\"input\" type=\"text\" name=\"technische_vaardigheden\" value=\" "+ myJson[0].technischeVaardigheden +"\" maxlength=\"256\"/><br>" +
				"Werkervaring: <input class=\"input\" type=\"text\" name=\"werkervaring\" value=\" "+ myJson[0].werkervaring +"\" maxlength=\"256\"/><br>" +
				"Platformen: <input class=\"input\" type=\"text\" name=\"platformen\" value=\" "+ myJson[0].platform +"\" maxlength=\"256\"/><br>" +
				"</div>"+
				"<div class=\"div_input_rechts\">" +
				"Geslacht: <input class=\"input\" type=\"text\" name=\"geslacht\" value=\"" + myJson[0].geslacht+ "\"maxlength=\"5\"/><br>" +
				"Huisnummer: <input class=\"input\" type=\"number\" name=\"huisnummer\" value= "+ huisnr +" maxlength=\"4\"/><br>" + 
				"Postcode: <input class=\"input\" type=\"text\" name=\"postcode\" value=\" "+ myJson[0].postcode +"\" maxlength=\"6\"/><br>" + 
				"Email: <input class=\"input\" type=\"text\" name=\"email\" value=\" "+ myJson[0].email +"\" maxlength=\"50\"/><br>" + 
				"Linkedin: <input class=\"input\" type=\"text\" name=\"linkedin\" value=\" "+ myJson[0].linkedin +"\" maxlength=\"50\"/><br>" +
				"<br><br><br><br><br><br><br><br>" +
				"Functionele vaardigheden: <input class=\"input\" type=\"text\" name=\"functionele_vaardigheden\" value=\" "+ myJson[0].functioneleVaardigheden +"\" maxlength=\"256\"/><br>" +
				"Computertalen: <input class=\"input\" type=\"text\" name=\"computertalen\" value=\" "+myJson[0].computertalen +"\" maxlength=\"256\"/><br>" +
				"Pakketen: <input class=\"input\" type=\"text\" name=\"pakketen\" value=\""+myJson[0].pakketten +"\" maxlength=\"256\"/>" +
				"<input class=\"submit\" type=\"button\" id=\"Put\" value=\"Aanpassen\"" +
				"</div>";
			
			putData();
		});
	
function putData(){	
	document.querySelector("#Put").addEventListener("click", function () {
		var formData = new FormData(document.querySelector("#FormPut"));
		 var encData = new URLSearchParams(formData.entries());
		 console.log(encData);
		 console.log(formData);
		 
		 let hoi = "hallo";
		 console.log(hoi)
		 
		 let fetchoptions = {
					method: 'PUT',
					body: encData,
				}
		 fetch('/restservices/WolfAndCherry/update', fetchoptions)
			.then((response) => {
				console.log(response.status);
				if(response.ok){
				 hoi = "response oke";
				 console.log("hoi")
				 }
				 else if (response.status == 500){
				 hoi = "status 500";
				 console.log(hoi)
				 }
				 else{
				 hoi = "de rest";
				 console.log(hoi);
				 console.log(response.status);
				 }
			});

	});
}
})