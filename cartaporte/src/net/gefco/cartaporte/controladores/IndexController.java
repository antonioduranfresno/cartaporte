package net.gefco.cartaporte.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.Usuario;
import net.gefco.cartaporte.negocio.AgenciaService;
import net.gefco.cartaporte.negocio.UsuarioService;
import net.gefco.cartaporte.util.Encriptacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Controller
@SessionAttributes("usuarioSesion")
public class IndexController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AgenciaService agenciaService;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@RequestMapping("/")
	public String showIndex(Model model){
		
		model.addAttribute("listaAgencias", agenciaService.listarAgencias());
		
		return "index";
	}

	@RequestMapping("/indice")
	public String showMenu() throws ParseException{
		return "indice";
	}
	
	@RequestMapping(value="/salir")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();  
	    session.invalidate();
	    
	    return "salir";
	}
	
	//@RequestMapping(value="/",method=RequestMethod.POST) Esto es como si fuera el post entero
	//Por eso especifico el nombre al que quiero que vaya, en lugar de manejar el tipoSubmit
	
	@RequestMapping("login")  
	public void login(Model model, HttpServletRequest request, HttpServletResponse response){

		try {
			
			Gson 					gson 						= new Gson(); 
			JsonObject 				myObj 						= new JsonObject();
			
			JsonElement				jsMensajeLogin 				= null;
						
			String login 	= request.getParameter("login");
			String password = request.getParameter("password");
			
			if(usuarioService.buscarMatricula(login.toUpperCase())!=null){
				
				Usuario usuarioAspirante = usuarioService.buscarMatricula(login.toUpperCase());
				
				if(Encriptacion.encriptar(password).equalsIgnoreCase(usuarioAspirante.getUsua_password())){
					
					model.addAttribute("usuarioSesion", usuarioAspirante);
					//Poner el maxinactiveinterval en XML
					
				}else{				
					jsMensajeLogin = gson.toJsonTree("Error. Password incorrecto.");				
				}	
				
			}else{			
				jsMensajeLogin = gson.toJsonTree("Error. El usuario no existe en la base de datos.");			
			}
			
			myObj.add("mensaje", jsMensajeLogin);		
			PrintWriter out = response.getWriter();		
			out.println(myObj.toString());	
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@RequestMapping("nuevoUsuario")  
	public void nuevoUsuario(HttpServletRequest request, HttpServletResponse response){
		
		try {
			
			Gson 					gson 						= new Gson(); 
			JsonObject 				myObj 						= new JsonObject();
			
			JsonElement				jsMensajeRegistro 			= null;
			
			String 	matricula 			= request.getParameter("matricula");		
			String 	nombre				= request.getParameter("nombre");
			String 	password			= request.getParameter("password");			
			Integer idAgencia			= new Integer(request.getParameter("agencia"));
			String 	correo	 			= request.getParameter("correo");
						
			if(usuarioService.buscarMatricula(matricula.toUpperCase())==null){
						
				Usuario usuario = new Usuario(0, matricula.toUpperCase(), nombre.toUpperCase(),  
												Encriptacion.encriptar(password), correo, new Agencia(idAgencia));				
				usuarioService.guardar(usuario);				
																
			}else{			
				jsMensajeRegistro = gson.toJsonTree("Error. El usuario "+matricula+" ya existe.");	
			}
					
			myObj.add("mensaje", jsMensajeRegistro);
			PrintWriter out = response.getWriter();		
			out.println(myObj.toString());	
			out.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
