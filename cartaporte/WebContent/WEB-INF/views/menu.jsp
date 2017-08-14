<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

        <nav class="navbar navbar-default navbar-static-top" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">CARTAS DE PORTE</a>
            </div>

            <ul class="nav navbar-top-links navbar-right" >            		
				<li><a href='${pageContext.request.contextPath}/salir' ><i class="fa fa-sign-out fa-lg"></i> SALIR</a></li>				
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
                            <a href="#"><b>MAESTROS</b><span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse in">
                            	<li>
                                    <a href="#"><i class="fa fa-gear fa-fw"></i> Compañías Transporte</a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-tasks fa-fw"></i> Conductores</a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-archive fa-fw"></i> Destinos</a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-exchange fa-fw"></i> Tipos Transporte</a>
                                </li>                                
                            </ul>                          
                        </li>                        
                                   	                        
                    </ul>
                </div>
            </div>
        </nav>
        