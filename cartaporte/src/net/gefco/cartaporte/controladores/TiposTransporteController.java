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
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuarioSesion")
public class TiposTransporteController {
	
	@Autowired
	private TipoTransporteService 		tipoTransporteService;
		
	@RequestMapping("/tiposTransporte")
	public String lista(Model model, @ModelAttribute("usuarioSesion") Usuario usuarioSesion, 
						@ModelAttribute("tipoTransporte") TipoTransporte tipoTransporte){		
		
		model.addAttribute("listaTiposTransporte", tipoTransporteService.listarTiposTransporte(usuarioSesion.getAgencia()));
		
		return "tiposTransporte";
	}

	@RequestMapping("/tiposTransporte/nuevo")
	public String nuevoDato(@ModelAttribute("usuarioSesion") Usuario usuarioSesion, 
							@ModelAttribute("tipoTransporte") @Valid TipoTransporte tipoTransporte, BindingResult result, Model model){
		
		if(result.hasErrors()) {
		
			return "redirect:/tiposTransporte";
			
		}else{

			/*if(tipoTransporteService.buscarTipoTransporte(tipoTransporte.getAgencia(), tipoTransporte.getTitr_nombre())==null){
				tipoTransporteService.guardar(tipoTransporte);
				return "redirect:/tiposTransporte?success=true";
			}else{
				return "redirect:/tiposTransporte?success=false";
			}*/
		
			return "redirect:/tiposTransporte";
			
		}
		
	}
	
}
