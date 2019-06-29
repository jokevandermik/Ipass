//koppelen aan een knop
//fetch komt hier
//post request
//authentication?

//als antwoord is 
//if response.ok()
//als antwoord is niet ok
//else

document.querySelector("#post").addEventListener("click", function () {
    var formData = new FormData(document.querySelector("#FormPost"));
    var encData = new URLSearchParams(formData.entries());
    
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
        //{response.json())
        //.then(function (myJson)  { console.log(myJson); });
	});
