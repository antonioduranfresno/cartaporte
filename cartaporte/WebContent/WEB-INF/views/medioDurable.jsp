<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
		
		<sf:form id="formMedioDurable" method="post" modelAttribute="medioDurable" >
		
		<sf:input type="hidden" path="id" value="${medioDurable.id}" />
		<sf:input type="hidden" path="cartaPorte.id" value="${medioDurable.cartaPorte.id}" />
		<sf:input type="hidden" path="cartaPorte.agencia.id" value="${medioDurable.cartaPorte.agencia.id}" />
		
		<div class="row">
			<div class="col-sm-5">
				<label>Tipo Medio Durable</label>
        		<sf:errors path="tipoMedioDurable.id" class="label label-danger"></sf:errors>
				<sf:select class="form-control" id="selTipoMedioDurable" path="tipoMedioDurable.id" value="${medioDurable.tipoMedioDurable.id}">
					<option value="0">Selección</option>
					<c:forEach items="${listaTiposMediosDurables}" var="c" varStatus="index">
	        			<option value="${c.id}" ${c.id == medioDurable.tipoMedioDurable.id ? 'selected' : '' }>${c.toStringCodigoDescripcion()}</option>
	        		</c:forEach>
				</sf:select>			        		
        	</div>
        	<div class="col-sm-2">
        		<label>Cantidad</label>
        		<sf:errors path="medu_cantidad" class="label label-danger"></sf:errors>
        		<sf:input class="form-control text-right" path="medu_cantidad" value="${medioDurable.medu_cantidad}" />		        		
        	</div>
        	<div class="col-sm-5">
        		<label>Observaciones</label>
        		<sf:errors path="medu_observaciones" class="label label-danger"></sf:errors>
        		<sf:input class="form-control" path="medu_observaciones" value="${medioDurable.medu_observaciones}" maxlength="40"/>   		
        	</div>		        			      				      		
		</div>
	
		<br>
		
		<div class="footer">      
			
		 	<div class="col-sm-12 derecha">			      		
	      		<input type="button" class="btn btn-primary" id="guardarMedioDurable" 
	      		name="guardarMedioDurable" value="Aceptar" onclick="guardarMedio();">
	      	</div>      	
		      	
		</div>		
		
		</sf:form>		
		
		<div>
		
		<table id="tablaMediosDurables" class='table table-hover table-striped table-condensed table-bordered'>
		
			<thead>
				<tr class="info">					
					<th class="col-sm-3">Tipo</th>
					<th class="col-sm-2">Cantidad</th>
					<th class="col-sm-6">Observaciones</th>
					<th class="col-sm-1">Eliminar</th>
				</tr>						
			</thead>
			
			<c:forEach items="${listaMediosDurables}" var="c" varStatus="index">
			
					<tr>
						<td>${c.tipoMedioDurable.toStringCodigoDescripcion()}</td>
						<td>${c.medu_cantidad}</td>
						<td>${c.medu_observaciones}</td>
						<td style="text-align: center;"><a href="#" onclick="eliminarMedioDurable(${c.id});" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
			
			</c:forEach>
			
		</table>
		
		</div>
	