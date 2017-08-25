	function eliminar(id, objeto){
		
		if(id!=""){
			if(confirm("¿Desea eliminar el registro?")){

				$.ajax({
					type	 	: "post",
					url      	: objeto+"Lista&id="+id+"/eliminar",
					data 	 	: {}		
				}).done(function (data) {				
					$(location).attr('href',objeto+'Lista?success=true');
				}).fail(function (jqXHR, textStatus) {
				    console.log("Error: "+textStatus);
				});
				
			}			
		}else{
			alert("No se puede realizar la acción.");
		}

	}