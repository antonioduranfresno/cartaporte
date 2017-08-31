package net.gefco.cartaporte.controladores;

import javax.validation.Valid;

import net.gefco.cartaporte.modelo.Conductor;
import net.gefco.cartaporte.modelo.Usuario;
import net.gefco.cartaporte.negocio.CompaniaTransporteService;
import net.gefco.cartaporte.negocio.ConductorService;

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
public class ConductorController {
	
	@Autowired
	private ConductorService 				conductorService;
	
	@Autowired
	private CompaniaTransporteService 		companiaTransporteService;
		
	@RequestMapping(value = "/conductorLista", method = RequestMethod.GET)
	public String lista(Model model, @ModelAttribute("conductor") Conductor conductor){		
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		
		model.addAttribute("listaConductoresAgencia", conductorService.listarConductoresAgencia(usuarioSesion.getAgencia()));
		
		return "conductorLista";
	}
	
	//Tanto para crear nuevo Tipo como para visualizar existente; @RequestParam opcional 
	@RequestMapping(value = "/conductorForm", method = RequestMethod.GET)
	public String mostrarFormulario(Model model, @RequestParam(value="id",required=false) Integer id){
		
		Conductor conductor = conductorService.buscarConductor(id);
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		model.addAttribute("listaCompaniasTransporte", companiaTransporteService.listarCompaniasTransporte(usuarioSesion.getAgencia()));
		
		if(id!=null){
			model.addAttribute("conductor", conductor);	
		}else{
			model.addAttribute("conductor", new Conductor());
		}
				
		return "conductorForm";
	}
	
	//Tanto para crear uno nuevo como para editar uno existente
	@RequestMapping(value = "/conductorForm", method = RequestMethod.POST, params="action=Aceptar")
	public String aceptar(Model model,
			@ModelAttribute("conductor") @Valid Conductor conductor, 
			BindingResult result){
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		FieldError error;
        
        if (conductor.getCompaniaTransporte().getId() ==0){
               error = new FieldError("conductor", "companiaTransporte.id", "Seleccione una compañía de transporte" );
               result.addError(error);
        }
        
		if(result.hasErrors()){
			model.addAttribute("listaCompaniasTransporte", companiaTransporteService.listarCompaniasTransporte(usuarioSesion.getAgencia()));
			return "conductorForm";
		} 
		
		try{
			
			//Creación
			if(conductor.getId()==null || conductor.getId()==0){
			
				conductor.setId(0);
									
				conductorService.guardar(conductor);
				
                conductor = new Conductor();
                
			//Actualización	
			}else{				
				conductorService.actualizar(conductor);				
			}
            
			return "redirect:/conductorLista?success=true";
            
         } catch (Exception e) {
                
                if (e.getClass().equals(DataIntegrityViolationException.class)){
                       error = new FieldError("conductor", "cond_dni", "Conductor duplicado para la compañía de transporte seleccionada" );
                } else {
                       error = new FieldError("conductor", "cond_dni", "error no controlado: " + e.getMessage());
                }
                
                result.addError(error);
                
    			model.addAttribute("listaCompaniasTransporte", companiaTransporteService.listarCompaniasTransporte(usuarioSesion.getAgencia()));
                return "conductorForm";
         }       
	         
		
	}
	
	@RequestMapping(value = "/conductorLista&id={id}/eliminar", method = RequestMethod.POST)
	public String eliminarDeLista(@PathVariable("id") Integer id){
		
		Conductor conductor = conductorService.buscarConductor(id);
		
		conductorService.eliminar(conductor);
		
		return "conductorLista";
	}
	
	/*Ya no se usa
	@RequestMapping(value = "/conductor", method = RequestMethod.POST, params="action=Eliminar")
	public String eliminar(Model model, @ModelAttribute("conductor") Conductor conductor ){
		
		//Faltaría ver en qué casos no se podría eliminar (relaciones)
		conductorService.eliminar(conductor);
		
		return "redirect:/conductores?success=true";
		
	}
	*/
	
}