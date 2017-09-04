$(document).ready(function() {
	
	$("#ruta_horaDocumentacion").val($("#ruta_horaDocumentacion").val().substring(11,16));
	$("#ruta_horaSalida").val($("#ruta_horaSalida").val().substring(11,16));	
	$("#entr_horaLlegada").val($("#entr_horaLlegada").val().substring(11,16));
	
	if($("#id").val()!=""){
		$("#btnAceptar").attr("disabled", true);
		$("#formEntrega").show();
		
		$('#divHoraLlegada').datetimepicker({
			language: 'ES',
			format: "hh:ii",
	        autoclose: true,
	        maxView: 2,
	        startView: 1
		});	
		
	}else{

		$("#btnAceptar").attr("disabled", false);
		$("#formEntrega").css("display","none");
		
		$('#divHoraDocumentacion').datetimepicker({
			language: 'ES',
			format: "hh:ii",
	        autoclose: true,
	        maxView: 2,
	        startView: 1
		});	

		$('#divHoraSalida').datetimepicker({
			language: 'ES',
			format: "hh:ii",
	        autoclose: true,
	        maxView: 2,
	        startView: 1
		});	
		
	}

});

function eliminarEntrega(id){
	
	if(id!=""){
		if(confirm("¿Desea eliminar el registro?")){

			$.ajax({
				type	 	: "post",
				url      	: "rutaForm&id="+id+"/eliminar",
				data 	 	: {}		
			}).done(function (data) {				
				$(location).attr('href',data);
				console.log("Devuelve algo: "+data);
			}).fail(function (jqXHR, textStatus) {
			    console.log("Error: "+textStatus);
			});
			
		}			
	}else{
		alert("No se puede realizar la acción.");
	}

}