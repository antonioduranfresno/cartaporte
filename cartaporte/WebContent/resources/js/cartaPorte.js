$(document).ready(function() {
	
	cargaEtiquetas();
	
	$("#capo_numeroCarta").attr("readonly", true);
	$("#capo_razonSocialCompania").attr("readonly", true);
	$("#capo_domicilioCompania").attr("readonly", true);
	$("#capo_domicilioCompaniaEfectiva").attr("readonly", true);
	$("#carneConducir").attr("readonly", true);
	$("#fechaExpedicion").attr("readonly", true);
	$("#origen").attr("readonly", true);
	
	$('#divFechaDocumentacion').datetimepicker({
	 	language: 'es',
	 	format: "dd/mm/yyyy hh:ii",
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 0,
		forceParse: 0			
	});	
	
	$('#divFechaSalida').datetimepicker({
	 	language: 'es',
	 	format: "dd/mm/yyyy hh:ii",
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 0,
		forceParse: 0			
	});	
	
	$('#divFechaLlegada').datetimepicker({
	 	language: 'es',
	 	format: "dd/mm/yyyy hh:ii",
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 0,
		forceParse: 0			
	});	

});
		

$("#selCompaniaTransporte").change( function(){
	
	var selector			= document.getElementById("selCompaniaTransporte");
	var idCompania			= selector.options[selector.selectedIndex].value;
	
	$.ajax({
		type	 	: "post",
		url      	: "cartaPorteForm/selCompania="+idCompania,
		dataType	: "json",
		data 	 	: "",		
	}).done(function (data) {    			
		
		$("#capo_domicilioCompaniaEfectiva").val(data.companiaEfectiva.cotr_domicilio);
		$("#capo_razonSocialCompaniaEfectiva").val(data.companiaEfectiva.cotr_razonSocial);
		$("#capo_cifCompaniaEfectiva").val(data.companiaEfectiva.cotr_cif);
		
		
		$("#selConductor").html(data.listaConductores);
		$("#selCamionTractor").html(data.listaCamionesTractores);
		$("#selCamionNoTractor").html(data.listaCamionesNoTractores);
		
		$("#carneConducir").val("");
		$("#fechaExpedicion").val("");
		$("#telefonoConductor").val("");    	
	}).fail(function (jqXHR, textStatus) {
	    console.log("Error: "+textStatus);
	});
	
});

$("#selConductor").change( function(){
	
	var selector			= document.getElementById("selConductor");
	var idConductor			= selector.options[selector.selectedIndex].value;
	
	if(idConductor != 0){
		
		$.ajax({
			type	 	: "post",
			url      	: "cartaPorteForm/selConductor="+idConductor,
			dataType	: "json",
			data 	 	: "",		
		}).done(function (data) {    			
			$("#carneConducir").val(data.conductor.cond_carne);
			$("#fechaExpedicion").val(data.fechaExpedicion);
			$("#telefonoConductor").val(data.conductor.cond_telefono);    			
		}).fail(function (jqXHR, textStatus) {
			console.log("Error: "+textStatus);
		});
		
	}
	
});

function cargaEtiquetas(){
	
	var selector			= document.getElementById("selModelo");
	var idModelo			= selector.options[selector.selectedIndex].value;	
	var valorModelo			= selector.options[selector.selectedIndex].text;
	
	if(idModelo != 1){
		$("#tabMercancia").removeClass("disabled");
		$("#tabMercancia").removeClass("disabledTab");
		
		var array = valorModelo.split("/");
		
		var campo1 = array[0];
		var campo2 = array[1];
		var campo3 = array[2];
		var campo4 = array[3];
		
		$("#modeloCabecera1").html(campo1);
		$("#modeloCabecera2").html(campo2);
		$("#modeloCabecera3").html(campo3);
		$("#modeloCabecera4").html(campo4);
		
		$("#tituloCampo1").html(campo1);
		$("#tituloCampo2").html(campo2);
		$("#tituloCampo3").html(campo3);
		$("#tituloCampo4").html(campo4);
		
	}else{
		$("#tabMercancia").addClass("disabled");
		$("#tabMercancia").addClass("disabledTab");
	}
}

function guardarMercanciaClick(){
	
	if(confirm("¿Desea añadir la mercancía a la carta de porte?")){
		
		$.ajax({
			type	 	: "post",
			url      	: "cartaPorteForm/guardarMercancia",
			data 	 	: $("#formMercancia").serialize()			
		}).done(function (data) {	
			
			$("#divMercancia").html(data);
			cargaEtiquetas();			
			
		}).fail(function (jqXHR, textStatus) {
		    console.log("Error: "+textStatus);
		});
		
	}
	
};

function guardarMedio(){
		
	if(confirm("¿Desea añadir el medio durable a la carta de porte?")){
		
		$.ajax({
			type	 	: "post",
			url      	: "cartaPorteForm/guardarMedioDurable",
			data 	 	: $("#formMedioDurable").serialize()			
		}).done(function (data) {	
			
			$("#divMediosDurables").html(data);
			
		}).fail(function (jqXHR, textStatus) {
		    console.log("Error: "+textStatus);
		});
		
	}
	
};

function eliminarMedioDurable(id){
	
	if(id!=""){
		if(confirm("¿Desea eliminar el registro?")){

			$.ajax({
				type	 	: "post",
				url      	: "medioDurable&id="+id+"/eliminar",
				data 	 	: {}		
			}).done(function (data) {
				
				$("#divMediosDurables").html(data);
				
			}).fail(function (jqXHR, textStatus) {
			    console.log("Error: "+textStatus);
			});
			
		}			
	}else{
		alert("No se puede realizar la acción.");
	}

}

function eliminarMercancia(id){
	
	if(id!=""){
		if(confirm("¿Desea eliminar el registro?")){

			$.ajax({
				type	 	: "post",
				url      	: "mercancia&id="+id+"/eliminar",
				data 	 	: {}		
			}).done(function (data) {
				
				$("#divMercancia").html(data);
				cargaEtiquetas();			
				
			}).fail(function (jqXHR, textStatus) {
			    console.log("Error: "+textStatus);
			});
			
		}			
	}else{
		alert("No se puede realizar la acción.");
	}

}

$("#guardar").click(function(){
	
	if($("#precinto").val()==""){
		
		if(confirm("No ha introducido número de Precinto. ¿Desea continuar?")){
			$("#guardar").prop("type", "submit");
		}
		
	}else{
		$("#guardar").prop("type", "submit");
	}
	
	
});
