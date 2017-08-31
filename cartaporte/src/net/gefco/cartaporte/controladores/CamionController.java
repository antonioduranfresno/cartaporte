package net.gefco.cartaporte.controladores;

import javax.validation.Valid;

import net.gefco.cartaporte.modelo.Camion;
import net.gefco.cartaporte.modelo.Usuario;
import net.gefco.cartaporte.negocio.CamionService;
import net.gefco.cartaporte.negocio.CompaniaTransporteService;

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
public class CamionController {
	
	@Autowired
	private CamionService 		camionService;
	
	@Autowired
	private CompaniaTransporteService companiaTransporteService;
		
	@RequestMapping(value = "/camionLista", method = RequestMethod.GET)
	public String lista(Model model, @ModelAttribute("camion") Camion camion){		
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		
		model.addAttribute("listaCamiones", camionService.listarCamionesAgencia(usuarioSesion.getAgencia()));
				
		return "camionLista";
	}
	
	//Tanto para crear nuevo Tipo como para visualizar existente; @RequestParam opcional 
	@RequestMapping(value = "/camionForm", method = RequestMethod.GET)
	public String mostrarFormulario(Model model, @RequestParam(value="idCamion",required=false) Integer idCamion){
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		
		Camion camion = camionService.buscarCamion(idCamion);
		
		if(idCamion!=null){
			model.addAttribute("camion", camion);	
		}else{
			model.addAttribute("camion", new Camion());
		}
		
		model.addAttribute("listaCompaniasTransporte", companiaTransporteService.listarCompaniasTransporte(usuarioSesion.getAgencia()));
		
		return "camionForm";
	}
	
	//Tanto para crear uno nuevo como para editar uno existente
	@RequestMapping(value = "/camionForm", method = RequestMethod.POST, params="action=Aceptar")
	public String aceptar(Model model,@ModelAttribute("camion") @Valid Camion camion, BindingResult result){
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		
		if(camion.getCompaniaTransporte().getId()==0){			
			FieldError error = new FieldError("camion", "companiaTransporte.id", "Por favor, seleccione una opción");			
			result.addError(error);			
		}
		
		if(result.hasErrors()){			
			model.addAttribute("listaCompaniasTransporte", companiaTransporteService.listarCompaniasTransporte(usuarioSesion.getAgencia()));			
			return "camionForm";			
		}

		try{
				
			//Creación
			if(camion.getId()==null || camion.getId()==0){
			
				camion.setId(0);	
				camionService.guardar(camion);				
				camion = new Camion();
                
			//Actualización	
			}else{				
				camionService.actualizar(camion);				
			}
            
			return "redirect:/camionLista?success=true";
							                
         } catch (Exception e) {
        	 
                FieldError error;
                
                if (e.getClass().equals(DataIntegrityViolationException.class)){	                	   
                       error = new FieldError("camion", "cami_matricula", "Matrícula duplicada para la compañía de transporte seleccionada");
                } else {
                       error = new FieldError("camion", "cami_matricula", "error no controlado: " + e.getMessage());
                }
                
                result.addError(error);                
                model.addAttribute("listaCompaniasTransporte", companiaTransporteService.listarCompaniasTransporte(usuarioSesion.getAgencia()));        
                return "camionForm";                
         } 
			
	}
	
	@RequestMapping(value = "/camionLista&id={idCamion}/eliminar", method = RequestMethod.POST)
	public String eliminarDeLista(@PathVariable("idCamion") Integer idCamion){
		
		Camion camion = camionService.buscarCamion(idCamion);
		
		camionService.eliminar(camion);
		
		return "camionLista";
	}
	
	
}