package net.gefco.cartaporte.controladores;

import javax.validation.Valid;

import net.gefco.cartaporte.modelo.TipoMedioDurable;
import net.gefco.cartaporte.modelo.Usuario;
import net.gefco.cartaporte.negocio.TipoMedioDurableService;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuarioSesion")
public class TipoMedioDurableController {
	
	@Autowired
	private TipoMedioDurableService 		tipoMedioDurableService;
		
	@RequestMapping(value = "/tipoMedioDurableLista", method = RequestMethod.GET)
	public String lista(Model model, @ModelAttribute("tipoMedioDurable") TipoMedioDurable tipoMedioDurable){		
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		
		model.addAttribute("listaTiposMediosDurables", tipoMedioDurableService.listarTiposMediosDurablesAgencia(usuarioSesion.getAgencia()));
				
		return "tipoMedioDurableLista";
	}
	
	//Tanto para crear nuevo Tipo como para visualizar existente; @RequestParam opcional 
	@RequestMapping(value = "/tipoMedioDurableForm", method = RequestMethod.GET)
	public String mostrarFormulario(Model model, @RequestParam(value="id",required=false) Integer id){
		
		TipoMedioDurable tipoMedioDurable = tipoMedioDurableService.buscarTipoMedioDurable(id);
		
		if(id != null){
			model.addAttribute("tipoMedioDurable", tipoMedioDurable);	
		}else{
			model.addAttribute("tipoMedioDurable", new TipoMedioDurable());
		}
				
		return "tipoMedioDurableForm";
	}
	
	//Tanto para crear uno nuevo como para editar uno existente
	@RequestMapping(value = "/tipoMedioDurableForm", method = RequestMethod.POST, params="action=Aceptar")
	public String aceptar(Model model,@ModelAttribute("tipoMedioDurable") @Valid TipoMedioDurable tipoMedioDurable, BindingResult result){
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		
		if(result.hasErrors()){
			return "tipoMedioDurableForm";
		}

		try{
			
			//Creación
			if(tipoMedioDurable.getId()==null || tipoMedioDurable.getId()==0){
			
				tipoMedioDurable.setId(0);
				tipoMedioDurable.setAgencia(usuarioSesion.getAgencia());
				
				tipoMedioDurableService.guardar(tipoMedioDurable);
				
                tipoMedioDurable = new TipoMedioDurable();
                
			//Actualización	
			}else{				
				tipoMedioDurableService.actualizar(tipoMedioDurable);				
			}
            
			return "redirect:/tipoMedioDurableLista?success=true";
            
         } catch (Exception e) {
        	 
                FieldError error;
                
                if (e.getClass().equals(DataIntegrityViolationException.class)){
                       error = new FieldError("tipoMedioDurable", "timd_codigo", "Código duplicado para su agencia");
                } else {
                       error = new FieldError("tipoMedioDurable", "timd_codigo", "error no controlado: " + e.getMessage());
                }
                
                result.addError(error);
        
                return "tipoMedioDurableForm";
                
         } 
			
		
	}
	
	@RequestMapping(value = "/tipoMedioDurableLista&id={id}/eliminar", method = RequestMethod.POST)
	@ResponseBody
	public String eliminarDeLista(@PathVariable("id") Integer id){
		
		TipoMedioDurable tipoMedioDurable = tipoMedioDurableService.buscarTipoMedioDurable(id);
		
		try{
			tipoMedioDurableService.eliminar(tipoMedioDurable);
			return "ok";			
		}catch(Exception e){			
			return "error";			
		}
	}

}