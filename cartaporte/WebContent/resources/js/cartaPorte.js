$(document).ready(function() {
	    	
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
				
	
});
