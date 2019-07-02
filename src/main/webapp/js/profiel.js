//koppelen aan een knop
//fetch komt hier
//post request
//authentication?

//als antwoord is 
//if response.ok()
//als antwoord is niet ok
//else


 
	function haalIDop(){
	var id;
    
 let fetchOptions = {
 method: 'GET',
 };
	
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
	input.innerHTML = "<input class='input' type='number' name='id' maxlength='4' value='" + id + "'/>";
});
}

	haalIDop();

	document.querySelector("#post").addEventListener("click", function () {
 var formData = new FormData(document.querySelector("#FormPost"));
 var encData = new URLSearchParams(formData.entries());
 console.log(encData);
 console.log(formData);
 
 let hoi = "hallo";
 console.log(hoi)
 
 let fetchoptions = {
			method: 'POST',
			body: encData,
		}
 fetch('/restservices/WolfAndCherry/save', fetchoptions)
	.then((response) => {
		console.log(response.status);
		if(response.ok){
		 hoi = "response oke";
		 console.log("hoi")
		 }
		 else if (response.status == 500){
		 hoi = "Server fout";
		 console.log(hoi)
		 }
		 else if (response.status == 405){
			 hoi = "Niet alle velden ingevuld";
			 console.log(hoi)
			 }
		 else{
		 hoi = "de rest";
		 console.log(hoi);
		 console.log(response.status);
		 }
	});

	});
