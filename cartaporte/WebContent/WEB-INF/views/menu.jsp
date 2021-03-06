<%@page import="net.gefco.cartaporte.modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<meta http-equiv="refresh" content="${pageContext.session.maxInactiveInterval};url='${pageContext.servletContext.contextPath}/salir'">

<% Usuario usuario = (Usuario) session.getAttribute("usuarioSesion"); %>

        <nav class="navbar navbar-default navbar-static-top" style="margin-bottom: 0">
            <div class="navbar-header">                
                <a class="navbar-brand" href="cartaPortePendienteLista">
                	<img src="res/img/bg/gefco.png">                	
                </a>
            </div>

            <ul class="nav navbar-top-links navbar-right" >            		
				<li><a href="salir" ><i class="fa fa-sign-out fa-lg"></i> SALIR</a></li>				
            </ul>
            <ul class="nav navbar-top-links navbar-right" >
				<li><a target="_blank" href="manual"><i class="fa fa-book fa-lg"></i> MANUAL</a></li>
			</ul>    
			<ul class="nav navbar-top-links navbar-right" >
				<li><a href="#" ><i class="fa fa-user fa-lg"></i> <%=usuario.toStringUsuario()%></a></li>		
			</ul>    

            <div class="navbar-default sidebar">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Buscar">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                        </li>                    
                        
						<li>
                            <a href="rutaLista" ><i class="fa fa-map-signs fa-fw"></i> RUTAS</a>
                        </li>   
                        
						<li>
                            <a href="#"><b>CARTAS DE PORTE</b><span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse in">
                                <li>
                                    <a href="cartaPortePendienteLista"><i class="fa fa-square-o fa-fw"></i> Pendientes</a>
                                </li>
                                <li>
                                    <a href="cartaPorteEmitidaLista"><i class="fa fa-check-square-o fa-fw"></i> Emitidas</a>
                                </li>                                                                
                            </ul>                          
                        </li>                                                   
                        
						<li>
                            <a href="#"><b>MAESTROS</b><span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse in">
                                <li>
                                    <a href="agenciaLista"><i class="fa fa-building-o fa-fw"></i> Agencias</a>
                                </li>                                                                                                
                                <li>
                                    <a href="tipoTransporteLista"><i class="fa fa-gear fa-fw"></i> Tipos Transporte</a>
                                </li>
                                <li>
                                    <a href="destinoLista"><i class="fa fa-globe fa-fw"></i> Destinos</a>
                                </li>
                            	<li>
                                    <a href="companiaTransporteLista"><i class="fa fa-cubes fa-fw"></i> Compañías </a>
                                </li>
                                <li>
                                    <a href="conductorLista"><i class="fa fa-group fa-fw"></i> Conductores</a>
                                </li>
                                <li>
                                    <a href="camionLista"><i class="fa fa-truck fa-fw"></i> Camiones</a>
                                </li> 
                                
                                <% if (usuario.getAgencia().getAgen_mediosDurables()){ %>
                                <li>
                                    <a href="tipoMedioDurableLista"><i class="fa fa-industry fa-fw"></i> Tipos MD</a>
                                </li>
                                <%} %>
                            </ul>                          
                        </li>    
                                   	                        
                    </ul>
                </div>
            </div>
        </nav>
        
