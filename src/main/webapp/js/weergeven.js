let hoi = "hallo";
	console.log(hoi);
	
	function init(){
				
		let fetchOptions = {
				method: 'GET'
		};
		
		fetch('/restservices/WolfAndCherry/all', fetchOptions)
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
				
				let table = document.querySelector('tbody');
				table.innerHTML = "";
				
				var i = 0;
				for (i; i < myJson.length; i++) {
					table.innerHTML = table.innerHTML + "<tr>" +
					"<td>"+ myJson[i].id +"</td> <td>"+ myJson[i].naam +"</td> <td>"+ myJson[i].straatnaam +"</td>";
				}
			});
		}
		
		init();