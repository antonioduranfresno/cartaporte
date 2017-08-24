	function eliminar(id){
		
		if(confirm("¿Desea eliminar el tipo de transporte?")){

			$.ajax({
				type	 	: "post",
				url      	: "tipoTransporteLista&idTipo="+id+"/eliminar",
				data 	 	: {}		
			}).done(function (data) {				
				$(location).attr('href','tipoTransporteLista?success=true');
			}).fail(function (jqXHR, textStatus) {
			    console.log("Error: "+textStatus);
			});
			
		}

	}