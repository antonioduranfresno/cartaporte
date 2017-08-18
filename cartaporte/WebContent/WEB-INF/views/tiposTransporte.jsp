<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <meta name="facturas" content="">
    <meta name="Antonio Durán" content="">
    <link rel="icon" href="res/img/ico/favicon.ico" type="image/x-icon" />
    
    <title>CARTAS DE PORTE - Gefco España S.A.</title>

    <link rel="stylesheet" href="res/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="res/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="res/css/sb-admin-2.min.css"/>      
    <link rel="stylesheet" href="res/css/metisMenu.min.css"/>
    <link rel="stylesheet" href="res/css/estilos.css"/>

  </head>

<body>

    <div id="wrapper">

		<jsp:include page="menu.jsp"/>

        <div id="page-wrapper">
        
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">Tipos transporte</h2>
                </div>                                
           </div> 
           
			<table id='tablaTiposTransporte' class='table table-hover table-striped table-condensed table-bordered'>
			
				<thead>
					<tr class="info">
						<th class="col-sm-12">Nombre</th>
					</tr>
				</thead>
			
				<c:forEach items="${listaTiposTransporte}" var="t" varStatus="index">
			
					<tr>
						<td>${t.titr_nombre}</td>
					</tr>
			
				</c:forEach>
			
			</table>
			
			<br>
			<a href="#" id="mostrarModalNuevo" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Nuevo</a>
			            
        </div>
    </div>
    
	<div id="modalNuevo" class="modal fade">
	 <sf:form method="post" modelAttribute="tipoTransporte" action="tiposTransporte/nuevo">
	  <div class="modal-dialog">
	
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">Nuevo Tipo de Transporte</h4>        
	      </div>
	      <div class="modal-body" >
	       
			 	<sf:input type="hidden" path="id" value="0" />
			 	<sf:input type="hidden" path="agencia.id" value="${usuarioSesion.agencia.id}" />
			 			
			   	<div class="row">
		        	<div class="col-lg-12">
		        		<label>Nombre</label>
		        		<sf:input class="form-control" path="titr_nombre" maxlength="45"  />
		        	</div>
			    </div>	
			  	          	        
	      </div>
	      <div class="modal-footer">
	      
	      	<button type="submit" id="crearNuevo" class="btn btn-primary" 
		    	data-loading-text="<i class='fa fa-circle-o-notch fa-spin'></i> Espere...">Aceptar</button>
	      	
	      </div>
	    </div>
	
	  </div>
	  </sf:form>
	</div>    
    

    <script type="text/javascript" src='<c:url value="/res/js/jquery-1.10.2.js" />' ></script>
	<script type="text/javascript" src='<c:url value="/res/js/bootstrap.min.js" />' ></script>    
	<script type="text/javascript" src='<c:url value="/res/js/sb-admin-2.js" />'></script>
    <script type="text/javascript" src='<c:url value="/res/js/metisMenu.min.js" />'></script>
    <script type="text/javascript" src='<c:url value="/res/js/jquery.dataTables.js" />'></script>
	<script type="text/javascript" src='<c:url value="/res/js/dataTables.bootstrap.js" />'></script>
    <script type="text/javascript" src='<c:url value="/res/js/loading.js" />'></script>
    
    <script type="text/javascript">
    
	$(document).ready(function() {
		
		cargaDatos();
		
		$('#mostrarModalNuevo').click(function(event){
			
			event.preventDefault();		
			$('#modalNuevo').modal({});
			event.stopImmediatePropagation();
			
		});
		
		/*
		$('#crearNuevo').click(function(e){
			
			e.preventDefault();
			e.stopImmediatePropagation();
			
			var valorNombre			= $('#titr_nombre').val();				
			
			if(valorNombre.length>0){			
				
				var $this = $(this);
				$this.button('loading');
			
				// get the array of all the inputs 
				var $inputs = $('#formularioNuevo :input');

			    // get an associative array of the values
				var values = {};
			    
				$.each($('#formularioNuevo').serializeArray(), function(i, field) {
				    values[field.name] = field.value;
				});
				
				if(confirm("¿Desea crear el nuevo tipo de transporte?")){
					
					$.ajax({
						type	 	: "post",
						url      	: "tiposTransporte/nuevo",
						data 	 	: values		
					}).done(function (data) {				
						alert("Ok");	
						$(":input","#formularioNuevo").val("");
        				$("#modalNuevo .close").click();
        				
					}).fail(function (jqXHR, textStatus) {
					    console.log("Error: "+textStatus);
					});
					
				}	
						
										
			}else{
				alert("Por favor, introduzca el tipo de transporte.");	
				$('#titr_nombre').focus();
			}				
						
		});	*/
		
	});
	
	
	function cargaDatos(){
		
		waitingDialog.show('Un momento, por favor...');
		
		$('#tablaTiposTransporte').DataTable({ 										
	    	"language": {
	    		"url": "res/json/es.json"
	        },
	    	"pageLength": 20,
	    	"initComplete": waitingDialog.hide()			 		    	
	    });		
		
			
	}
	
	
	
    
    </script>
    
</body>

</html>