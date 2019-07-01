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
			json = JSON.parse(myJson[0]);
			
			let input = document.getElementById('json');
			input.innerHTML = "Naam: <input class=\"input\" type=\"text\" name=\"naam\" value=\"" + json.naam + "\" maxlength=\"50\"/><br>"
		});
})