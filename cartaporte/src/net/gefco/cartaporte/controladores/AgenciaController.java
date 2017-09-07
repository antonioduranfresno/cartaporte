package net.gefco.cartaporte.controladores;

import javax.validation.Valid;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.negocio.AgenciaService;
import net.gefco.cartaporte.negocio.UOService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuarioSesion")
public class AgenciaController {
	
	@Autowired
	private AgenciaService 		agenciaService;
	
	@Autowired
	private UOService 			uoService;
	
			
	@RequestMapping(value = "/agenciaLista", method = RequestMethod.GET)
	public String lista(Model model, @ModelAttribute("agencia") Agencia agencia){		
		
		model.addAttribute("listaAgencias", agenciaService.listarAgencias());
					
		return "agenciaLista";
	}
	
	
	//Tanto para crear nuevo Tipo como para visualizar existente; @RequestParam opcional 
	@RequestMapping(value = "/agenciaForm", method = RequestMethod.GET)
	public String mostrarFormulario(Model model, @RequestParam(value="idAgencia",required=false) Integer idAgencia){
		
		Agencia agencia = agenciaService.buscarAgencia(idAgencia);
		
		if(idAgencia!=null){
			model.addAttribute("agencia", agencia);	
		}else{
			model.addAttribute("agencia", new Agencia());
		}
		
		model.addAttribute("listaUos", uoService.listarUnidadesOperacionales());
		return "agenciaForm";
	}
	
	//Tanto para crear uno nuevo como para editar uno existente
	@RequestMapping(value = "/agenciaForm", method = RequestMethod.POST, params="action=Aceptar")
	public String aceptar(Model model,@ModelAttribute("agencia") @Valid Agencia agencia, BindingResult result){
		if (agencia.getUo().getId() == 0 ) {
			FieldError error = new FieldError("agencia", "uo.id", "Debe seleccionar la UO");
			result.addError(error);
		}
		if(result.hasErrors()){			
			model.addAttribute("listaUos", uoService.listarUnidadesOperacionales());
			return "agenciaForm";			
		}

		try{
				
			//Creación
			if(agencia.getId()==null || agencia.getId()==0){
			
				agencia.setId(0);	
				agenciaService.guardar(agencia);				
				agencia = new Agencia();
                
			//Actualización	
			}else{				
				agenciaService.actualizar(agencia);				
			}
            
			return "redirect:/agenciaLista?success=true";
							                
         } catch (Exception e) {
        	 
                FieldError error;
                
                if (e.getClass().equals(DataIntegrityViolationException.class)){	                	   
                       error = new FieldError("agencia", "agen_nombre", "Ya existe una agencia con ese nombre");
                       error = new FieldError("agencia", "agen_codigo", "Ya existe una agencia con ese código");
                } else {
                       error = new FieldError("agencia", "agen_nombre", "error no controlado: " + e.getMessage());
                }
                
                result.addError(error);  
                model.addAttribute("listaUos", uoService.listarUnidadesOperacionales());
                return "agenciaForm";                
         } 
			
	}
	
	@RequestMapping(value = "/agenciaLista&id={idAgencia}/eliminar", method = RequestMethod.POST)
	public String eliminarDeLista(@PathVariable("idAgencia") Integer idAgencia){
		
		Agencia agencia = agenciaService.buscarAgencia(idAgencia);
		
		agenciaService.eliminar(agencia);
		
		return "agenciaLista";
	}
	
	
}