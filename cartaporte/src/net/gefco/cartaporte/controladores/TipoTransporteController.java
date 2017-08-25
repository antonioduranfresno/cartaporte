package net.gefco.cartaporte.controladores;

import javax.validation.Valid;

import net.gefco.cartaporte.modelo.TipoTransporte;
import net.gefco.cartaporte.modelo.Usuario;
import net.gefco.cartaporte.negocio.TipoTransporteService;

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
public class TipoTransporteController {
	
	@Autowired
	private TipoTransporteService 		tipoTransporteService;
		
	@RequestMapping(value = "/tipoTransporteLista", method = RequestMethod.GET)
	public String lista(Model model, @ModelAttribute("tipoTransporte") TipoTransporte tipoTransporte){		
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		
		model.addAttribute("listaTiposTransporte", tipoTransporteService.listarTiposTransporte(usuarioSesion.getAgencia()));
				
		return "tipoTransporteLista";
	}
	
	//Tanto para crear nuevo Tipo como para visualizar existente; @RequestParam opcional 
	@RequestMapping(value = "/tipoTransporteForm", method = RequestMethod.GET)
	public String mostrarFormulario(Model model, @RequestParam(value="idTipo",required=false) Integer idTipo){
		
		TipoTransporte tipoTransporte = tipoTransporteService.buscarTipoTransporteId(idTipo);
		
		if(idTipo!=null){
			model.addAttribute("tipoTransporte", tipoTransporte);	
		}else{
			model.addAttribute("tipoTransporte", new TipoTransporte());
		}
				
		return "tipoTransporteForm";
	}
	
	//Tanto para crear uno nuevo como para editar uno existente
	@RequestMapping(value = "/tipoTransporteForm", method = RequestMethod.POST, params="action=Aceptar")
	public String aceptar(Model model,@ModelAttribute("tipoTransporte") @Valid TipoTransporte tipoTransporte, BindingResult result){
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		
		if(result.hasErrors()){
			return "tipoTransporteForm";
		}

		try{
			
			//Creación
			if(tipoTransporte.getId()==null || tipoTransporte.getId()==0){
			
				tipoTransporte.setId(0);
				tipoTransporte.setAgencia(usuarioSesion.getAgencia());
				
				tipoTransporteService.guardar(tipoTransporte);				
                tipoTransporte = new TipoTransporte();
                
			//Actualización	
			}else{				
				tipoTransporteService.actualizar(tipoTransporte);				
			}
            
			return "redirect:/tipoTransporteLista?success=true";
            
         } catch (Exception e) {
        	 
                FieldError error;
                
                if (e.getClass().equals(DataIntegrityViolationException.class)){
                       error = new FieldError("tipoTransporte", "titr_nombre", "tipo de transporte duplicado para su agencia");
                } else {
                       error = new FieldError("tipoTransporte", "titr_nombre", "error no controlado: " + e.getMessage());
                }
                
                result.addError(error);
        
                return "tipoTransporteForm";                
         } 
		
	}
	
	@RequestMapping(value = "/tipoTransporteLista&id={idTipo}/eliminar", method = RequestMethod.POST)
	public String eliminarDeLista(@PathVariable("idTipo") Integer idTipo){
		
		TipoTransporte tipoTransporte = tipoTransporteService.buscarTipoTransporteId(idTipo);
		
		tipoTransporteService.eliminar(tipoTransporte);
		
		return "tipoTransporteLista";
	}
	
	/*Ya no se usa
	@RequestMapping(value = "/tipoTransporte", method = RequestMethod.POST, params="action=Eliminar")
	public String eliminar(Model model, @ModelAttribute("tipoTransporte") TipoTransporte tipoTransporte ){
		
		//Faltaría ver en qué casos no se podría eliminar (relaciones)
		tipoTransporteService.eliminar(tipoTransporte);
		
		return "redirect:/tiposTransporte?success=true";
		
	}
	*/
	
}