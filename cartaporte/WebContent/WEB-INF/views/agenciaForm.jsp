<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
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
                    <h2 class="page-header">Agencia</h2>
                </div>                                
           </div> 
           
           <sf:form method="post" modelAttribute="agencia" >
					
				<sf:input type="hidden" path="id" value="${agencia.id}" />
				
			   	<div class="row">
		        	<div class="col-lg-3">
		        		<label>Código</label>
		        		<sf:errors path="agen_codigo" class="label label-danger"></sf:errors>
		        		<sf:input  path="agen_codigo" class="form-control" value="${agencia.agen_codigo}" maxlength="3" />		        		
		        	</div>
		        	<div class="col-lg-5">
		        		<label>Nombre</label>
		        		<sf:errors path="agen_nombre" class="label label-danger"></sf:errors>
		        		<sf:input  path="agen_nombre" class="form-control" value="${agencia.agen_nombre}" maxlength="255" />		        		
		        	</div>
		        	<div class="col-lg-4">
                  		<label>UO</label>
                  		<sf:errors path="uo.id" class="label label-danger"></sf:errors>
                  		<sf:select class="form-control" id="selUo" path="uo.id" value="${agencia.uo.id}">
                       		<option value="0">Selección</option>
                          	<c:forEach items="${listaUos}" var="c" varStatus="index">
                          		<option value="${c.id}" ${c.id == agencia.uo.id ? 'selected' : '' }>${c.toStringCodigoNombre()}</option>
                   			</c:forEach>
                   		</sf:select>
		        	</div>
				</div>
				
				<div class="row">
		        	<div class="col-lg-4">
		        		<label>Contacto</label>
		        		<sf:errors path="agen_contacto" class="label label-danger"></sf:errors>
		        		<sf:input  path="agen_contacto" class="form-control" value="${agencia.agen_contacto}" maxlength="255" />		        		
		        	</div>
		        	<div class="col-lg-4">
		        		<label>Teléfono</label>
		        		<sf:errors path="agen_telefonoContacto" class="label label-danger"></sf:errors>
		        		<sf:input  path="agen_telefonoContacto" class="form-control" value="${agencia.agen_telefonoContacto}" maxlength="15" />		        		
		        	</div>
				</div>
				
				<div class="row">
		        	<div class="col-lg-3">
		        		<label>Copia Origen</label>		        		
		        		<sf:select class="form-control" path="agen_copiaOrigen" value="${agencia.agen_copiaOrigen}">
		        			<sf:option value="false">No</sf:option>		        		
		        			<sf:option value="true">Sí</sf:option>
		        		</sf:select>
		        	</div>	
		        	<div class="col-lg-3">
		        		<label>Copia Destino</label>		        		
		        		<sf:select class="form-control" path="agen_copiaDestino" value="${agencia.agen_copiaDestino}">
		        			<sf:option value="false">No</sf:option>		        		
		        			<sf:option value="true">Sí</sf:option>
		        		</sf:select>
		        	</div>
		        	<div class="col-lg-3">
		        		<label>Copia Transportista</label>		        		
		        		<sf:select class="form-control" path="agen_copiaTransportista" value="${agencia.agen_copiaTransportista}">
		        			<sf:option value="false">No</sf:option>		        		
		        			<sf:option value="true">Sí</sf:option>
		        		</sf:select>
		        	</div>	
		        	<div class="col-lg-3">
		        		<label>Copia Factura</label>		        		
		        		<sf:select class="form-control" path="agen_copiaFactura" value="${agencia.agen_copiaFactura}">
		        			<sf:option value="false">No</sf:option>		        		
		        			<sf:option value="true">Sí</sf:option>
		        		</sf:select>
		        	</div>
				</div>
				
				<div class="footer">      
				
					<div class="col-sm-10 derecha">			      		
			    		<input type="button" class="btn btn-danger" value="Eliminar"  onclick='eliminar($("#id").val(),"agencia");'>
			      	</div>      	
				 	<div class="col-sm-2 derecha">			      		
			      		<input type="submit" class="btn btn-primary" name="action" value="Aceptar" >
			      	</div>      	
			      	
			    </div>				
					
			</sf:form>
			            
        </div>
    </div>

    <script type="text/javascript" src='<c:url value="/res/js/jquery-1.10.2.js" />' ></script>
	<script type="text/javascript" src='<c:url value="/res/js/bootstrap.min.js" />' ></script>    
	<script type="text/javascript" src='<c:url value="/res/js/sb-admin-2.js" />'></script>
    <script type="text/javascript" src='<c:url value="/res/js/metisMenu.min.js" />'></script>    
    <script type="text/javascript" src='<c:url value="/res/js/loading.js" />'></script>
    <script type="text/javascript" src='<c:url value="/res/js/maestro.js" />'></script>
     
</body>

</html>