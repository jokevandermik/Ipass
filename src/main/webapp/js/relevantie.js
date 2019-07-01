document.querySelector("#post").addEventListener("click", function () {
	var lijst = document.getElementById("relevant");
	var relevantie = lijst.options[lijst.selectedIndex].value;
	console.log(relevantie)
	
//	let fetchOptions = {
//			method: 'GET'
//	};
//	
//	fetch('/restservices/WolfAndCherry/relevantie/' + relevantie, fetchOptions)
//		.then((response) => {
//			console.log(response.status);
//			if (response.status = 200){
//				hoi = "response oke";
//				console.log(hoi);
//				return response.json();
//			}
//			else if(response.status = 403){
//			hoi = "status  403";
//			console.log(hoi);
//			
//			}
//			else {
//				hoi = "de rest";
//				console.log(hoi);
//				console.log(response.status);
//			}
//		})
//		.then((myJson) => {
//			console.log(JSON.stringify(myJson));
//		});
})