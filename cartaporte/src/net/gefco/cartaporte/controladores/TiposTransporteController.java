package net.gefco.cartaporte.controladores;

import javax.validation.Valid;

import net.gefco.cartaporte.modelo.TipoTransporte;
import net.gefco.cartaporte.modelo.Usuario;
import net.gefco.cartaporte.negocio.TipoTransporteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuarioSesion")
public class TiposTransporteController {
	
	@Autowired
	private TipoTransporteService 		tipoTransporteService;
		
	@RequestMapping(value = "/tiposTransporte", method = RequestMethod.GET)
	public String lista(Model model, @ModelAttribute("usuarioSesion") Usuario usuarioSesion, 
						@ModelAttribute("tipoTransporte") TipoTransporte tipoTransporte){		
		
		model.addAttribute("listaTiposTransporte", tipoTransporteService.listarTiposTransporte(usuarioSesion.getAgencia()));
				
		return "tiposTransporte";
	}
	
	@RequestMapping(value = "/tiposTransporte", method = RequestMethod.POST)
	public String nuevoDato(Model model, @ModelAttribute("usuarioSesion") Usuario usuarioSesion, 
							@ModelAttribute("tipoTransporte") @Valid TipoTransporte tipoTransporte, BindingResult result){
		
		if(!result.hasErrors()){
			
			if(tipoTransporteService.buscarTipoTransporte(tipoTransporte.getAgencia(), tipoTransporte.getTitr_nombre())==null){
				tipoTransporteService.guardar(tipoTransporte);
				return "redirect:/tiposTransporte?success=true";	
			}else{
				return "redirect:/tiposTransporte?success=false";
			}
			
		}else{
			
			model.addAttribute("listaTiposTransporte", tipoTransporteService.listarTiposTransporte(usuarioSesion.getAgencia()));
			model.addAttribute("error","error");
			
		    return "tiposTransporte";
		}
		
	}
	
}
