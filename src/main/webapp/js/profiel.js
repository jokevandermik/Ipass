//koppelen aan een knop
//fetch komt hier
//post request
//authentication?

//als antwoord is 
//if response.ok()
//als antwoord is niet ok
//else

document.querySelector("#post").addEventListener("click", function () {
    var formData = new FormData(document.querySelector("#POSTcustomerForm"));
    var encData = new URLSearchParams(formData.entries());

    fetch("restservices/customers", { method: 'POST', body: encData })
        .then(response => response.json())
        .then(function (myJson) { console.log(myJson); });
});
