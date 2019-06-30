//koppelen aan een knop
//fetch komt hier
//post request
//authentication?

//als antwoord is 
//if response.ok()
//als antwoord is niet ok
//else

document.querySelector("#post").addEventListener("click", function () {
// var id;
// id = id + 1;
//	
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
	
});
	 // fetch(idhalen)
    // id json var maken
    // maak var boven aan undifind var
    // geeft json aan var
    // doe +1 bij var
	// gooi er wat console.logs in
    
	var formData = new FormData(document.querySelector("#FormPost"));
    var encData = new URLSearchParams(formData.entries() + id.entries());
    
    let hoi = "hallo";
    console.log(hoi)
    
    fetch("restservices/WolfAndCherry/save", { method: 'POST', body: encData })
        .then(response => {
        	console.log(response.status);
        	if (response.ok){
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
        // {response.json())
        // .then(function (myJson) { console.log(myJson); });
	});
