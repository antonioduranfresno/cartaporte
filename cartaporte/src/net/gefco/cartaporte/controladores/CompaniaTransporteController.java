package net.gefco.cartaporte.controladores;

import javax.validation.Valid;

import net.gefco.cartaporte.modelo.CompaniaTransporte;
import net.gefco.cartaporte.modelo.TipoTransporte;
import net.gefco.cartaporte.modelo.Usuario;
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
public class CompaniaTransporteController {
	
	@Autowired
	private CompaniaTransporteService 		companiaTransporteService;
		
	@RequestMapping(value = "/companiaTransporteLista", method = RequestMethod.GET)
	public String lista(Model model, @ModelAttribute("companiaTransporte") TipoTransporte tipoTransporte){		
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		
		model.addAttribute("listaCompaniasTransporte", companiaTransporteService.listarCompaniasTransporte(usuarioSesion.getAgencia()));
				
		return "companiaTransporteLista";
	}
	
	//Tanto para crear nuevo Tipo como para visualizar existente; @RequestParam opcional 
	@RequestMapping(value = "/companiaTransporteForm", method = RequestMethod.GET)
	public String mostrarFormulario(Model model, @RequestParam(value="idCompania",required=false) Integer idCompania){
		
		CompaniaTransporte companiaTransporte = companiaTransporteService.buscarCompaniaTransporte(idCompania);
		
		if(idCompania!=null){
			model.addAttribute("companiaTransporte", companiaTransporte);	
		}else{
			model.addAttribute("companiaTransporte", new CompaniaTransporte());
		}
				
		return "companiaTransporteForm";
	}
	
	//Tanto para crear uno nuevo como para editar uno existente
	@RequestMapping(value = "/companiaTransporteForm", method = RequestMethod.POST, params="action=Aceptar")
	public String aceptar(Model model,@ModelAttribute("companiaTransporte") @Valid CompaniaTransporte companiaTransporte, BindingResult result){
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		
		if(result.hasErrors()){
			return "companiaTransporteForm";			
		}

		try{
			
			//Creación
			if(companiaTransporte.getId()==null || companiaTransporte.getId()==0){
			
				companiaTransporte.setId(0);
				companiaTransporte.setAgencia(usuarioSesion.getAgencia());
				
				companiaTransporteService.guardar(companiaTransporte);				
				companiaTransporte = new CompaniaTransporte();
                
			//Actualización	
			}else{				
				companiaTransporteService.actualizar(companiaTransporte);				
			}
            
			return "redirect:/companiaTransporteLista?success=true";
            
         } catch (Exception e) {
        	 
                FieldError error;
                
                if (e.getClass().equals(DataIntegrityViolationException.class)){
                       error = new FieldError("companiaTransporte", "cotr_codigo", "Código de companía duplicado para su agencia");
                } else {
                       error = new FieldError("companiaTransporte", "cotr_codigo", "error no controlado: " + e.getMessage());
                }
                
                result.addError(error);
        
                return "companiaTransporteForm";                
         } 
		
	}
	
	@RequestMapping(value = "/companiaTransporteLista&id={idCompania}/eliminar", method = RequestMethod.POST)
	public String eliminarDeLista(@PathVariable("idCompania") Integer idCompania){
		
		CompaniaTransporte companiaTransporte = companiaTransporteService.buscarCompaniaTransporte(idCompania);
		
		companiaTransporteService.eliminar(companiaTransporte);
		
		return "companiaTransporteLista";
	}
	
}