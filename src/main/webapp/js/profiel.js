//koppelen aan een knop
//fetch komt hier
//post request
//authentication?

//als antwoord is 
//if response.ok()
//als antwoord is niet ok
//else


 
	function haalIDop(){
	var jsid;
 
	
	
	let hoi = "hallo";
    console.log(hoi)
    
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
	jsid = JSON.parse(myJson[0].id);
	console.log(jsid);
	jsid = jsid + 1;
	console.log(jsid);
	
	document.getElementById('id').innerHTML = "<input class='input' type='number' name='jsid' maxlength='4' value='" + jsid + "'/>";
});
}

	haalIDop();
	
	 // fetch(idhalen)
    // id json var maken
    // maak var boven aan undifind var
    // geeft json aan var
    // doe +1 bij var
	// gooi er wat console.logs in

	document.querySelector("#post").addEventListener("click", function () {
// var formData = new FormData(document.querySelector("#FormPost"));
// var encData = new URLSearchParams(formData.entries());
// console.log(encData);
// console.log(formData);
// encData = new URLSearchParams(formData.entries() + jsid.entries());
// console.log(encData)
// hoi = "response oke";
// console.log("hoi")
// }
// else if (response.status == 500){
// hoi = "status 500";
// console.log(hoi)
// }
// else{
// hoi = "de rest";
// console.log(hoi);
// console.log(response.status);
// }
// });
        // {response.json())
        // .then(function (myJson) { console.log(myJson); });
	});
