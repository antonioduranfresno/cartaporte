<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
		
		<sf:form id="formMercancia" method="post" modelAttribute="mercancia" >
		
		<sf:input type="hidden" path="id" value="${mercancia.id}" />
		<sf:input type="hidden" path="cartaPorte.id" value="${mercancia.cartaPorte.id}" />
		
		<div class="row">
			<div class="col-sm-6">
        		<label id="modeloCabecera1"></label>
        		<sf:errors path="merc_campo1" class="label label-danger"></sf:errors>
        		<sf:input class="form-control" path="merc_campo1" value="${mercancia.merc_campo1}" />		        		
        	</div>
        	<div class="col-sm-3">
        		<label id="modeloCabecera2"></label>
        		<sf:errors path="merc_campo2" class="label label-danger"></sf:errors>
        		<sf:input class="form-control" path="merc_campo2" value="${mercancia.merc_campo2}" />		        		
        	</div>
        	<div class="col-sm-3">
        		<label id="modeloCabecera3"></label>
        		<sf:errors path="merc_campo3" class="label label-danger"></sf:errors>
        		<sf:input class="form-control text-right" path="merc_campo3" value="${mercancia.merc_campo3}" />   		
        	</div>		        			      				      		
		</div>
		
		<div class="row">
			<div class="col-sm-12">
        		<label id="modeloCabecera4"></label>
        		<sf:errors path="merc_campo4" class="label label-danger"></sf:errors>
        		<sf:input class="form-control" path="merc_campo4" value="${mercancia.merc_campo4}" />	        		
        	</div>
		</div>		
		
		<br>
		
		<div class="footer">      
			
		 	<div class="col-sm-12 derecha">			      		
	      		<input type="button" class="btn btn-primary" id="guardarMercancia" name="guardarMercancia" value="Aceptar" onclick="guardarMercanciaClick();">
	      	</div>      	
		      	
		</div>		
		
		</sf:form>		
		
		<div>
		
		<table id="tablaMercancias" class='table table-hover table-striped table-condensed table-bordered'>
		
			<thead>
				<tr class="info">
					<th id="tituloCampo1"></th>
					<th id="tituloCampo2"></th>
					<th id="tituloCampo3"></th>
					<th id="tituloCampo4"></th>
					<th class="col-sm-1">Eliminar</th>
				</tr>						
			</thead>
			
			<c:forEach items="${listaMercancias}" var="c" varStatus="index">
			
					<tr>
						<td>${c.merc_campo1}</td>
						<td>${c.merc_campo2}</td>
						<td>${c.merc_campo3}</td>
						<td>${c.merc_campo4}</td>
						<td style="text-align: center;">
							<a href="#" onclick="eliminarMercancia(${c.id});" class="btn btn-default">
								<span class="glyphicon glyphicon-trash"></span>
							</a>
						</td>
					</tr>
			
			</c:forEach>
			
		</table>
		
		</div>
