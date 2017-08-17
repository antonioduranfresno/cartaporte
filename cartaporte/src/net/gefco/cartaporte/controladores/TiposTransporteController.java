package net.gefco.cartaporte.controladores;

import net.gefco.cartaporte.modelo.TipoTransporte;
import net.gefco.cartaporte.modelo.Usuario;
import net.gefco.cartaporte.negocio.TipoTransporteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuarioSesion")
public class TiposTransporteController {
	
	@Autowired
	private TipoTransporteService 		tipoTransporteService;
		
	@RequestMapping("/tiposTransporte")
	public String lista(Model model, @ModelAttribute("usuarioSesion") Usuario usuarioSesion){		
		
		model.addAttribute("listaTiposTransporte", tipoTransporteService.listarTiposTransporte(usuarioSesion.getAgencia()));
		
		return "tiposTransporte";
	}

	@RequestMapping("/tiposTransporte/nuevo")
	public String nuevoDato(Model model, @ModelAttribute("usuarioSesion") Usuario usuarioSesion, @ModelAttribute("tipoTransporte") TipoTransporte tipoTransporte){
		
		tipoTransporteService.guardar(tipoTransporte);
		
		model.addAttribute("listaTiposTransporte", tipoTransporteService.listarTiposTransporte(usuarioSesion.getAgencia()));
		
		return lista(model, usuarioSesion);
	}
	
}
