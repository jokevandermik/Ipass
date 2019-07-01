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