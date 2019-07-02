//functie haalIDop zorgt ervoor dat er een nieuw id bepaald wordt voor het nieuwe profiel.
function haalIDop(){
var id;
    
 let fetchOptions = {
 method: 'GET',
 };
	//ropet webservice aan om profielen aan te maken
 fetch('/restservices/WolfAndCherry/Idhalen', fetchOptions)
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
	id = JSON.parse(myJson[0].id);
	console.log(id);
	id = id + 1;
	console.log(id);
	
	let input = document.getElementById('id');
	input.innerHTML = "ID: <input class='input' type='number' name='id' maxlength='4' value='" + id + "' readonly/>";
});
}

	haalIDop();
	//commando om te wachten tot er wordt gedrukt op de button in de index.html
	document.querySelector("#post").addEventListener("click", function () {
 var formData = new FormData(document.querySelector("#FormPost"));
 var encData = new URLSearchParams(formData.entries());
 console.log(encData);
 console.log(formData);
 
 let status = document.querySelector('error');
 status.innerHTML = "";
 console.log(status);
 
 let fetchoptions = {
			method: 'POST',
			body: encData,
		}
 // roept webservice aan om gegevens op te slaan
 fetch('/restservices/WolfAndCherry/save', fetchoptions)
	.then((response) => {
		console.log(response.status);
		if(response.ok){
		 status.innerHTML = status.innerHTML + "Het profiel is aangemaakt.";
		 console.log(status);
		 location.reload();
		 }
		 else if (response.status == 500){
		 status.innerHTML = status.innerHTML +  "Server fout. Profiel aanmaken mislukt.";
		 console.log(status)
		 
		 }
		 else if (response.status == 405){
			 status.innerHTML = status.innerHTML +  "Niet alle velden ingevuld. Profiel aanmaken mislukt.";
			 console.log(status)
			 }
		 else{
		status.innerHTML = status.innerHTML +  "Er is een onbekende fout opgetreden.";
		 console.log(status);
		 console.log(response.status);
		 }
	});

	});
