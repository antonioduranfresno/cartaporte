package net.gefco.cartaporte.controladores;

import javax.validation.Valid;

import net.gefco.cartaporte.modelo.Destino;
import net.gefco.cartaporte.modelo.Usuario;
import net.gefco.cartaporte.negocio.DestinoService;

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
public class DestinoController {
	
	@Autowired
	private DestinoService 		destinoService;
		
	@RequestMapping(value = "/destinoLista", method = RequestMethod.GET)
	public String lista(Model model, @ModelAttribute("destino") Destino destino){		
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		
		model.addAttribute("listaDestinos", destinoService.listarDestinos(usuarioSesion.getAgencia()));
				
		return "destinoLista";
	}
	
	//Tanto para crear nuevo Tipo como para visualizar existente; @RequestParam opcional 
	@RequestMapping(value = "/destinoForm", method = RequestMethod.GET)
	public String mostrarFormulario(Model model, @RequestParam(value="id",required=false) Integer id){
		
		Destino destino = destinoService.buscarDestino(id);
		
		if(id != null){
			model.addAttribute("destino", destino);	
		}else{
			model.addAttribute("destino", new Destino());
		}
				
		return "destinoForm";
	}
	
	//Tanto para crear uno nuevo como para editar uno existente
	@RequestMapping(value = "/destinoForm", method = RequestMethod.POST, params="action=Aceptar")
	public String aceptar(Model model,@ModelAttribute("destino") @Valid Destino destino, BindingResult result){
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		
		if(result.hasErrors()){
			return "destinoForm";
		}

		try{
			
			//Creación
			if(destino.getId()==null || destino.getId()==0){
			
				destino.setId(0);
				destino.setAgencia(usuarioSesion.getAgencia());
				
				destinoService.guardar(destino);
				
                destino = new Destino();
                
			//Actualización	
			}else{				
				destinoService.actualizar(destino);				
			}
            
			return "redirect:/destinoLista?success=true";
            
         } catch (Exception e) {
        	 
                FieldError error;
                
                if (e.getClass().equals(DataIntegrityViolationException.class)){
                       error = new FieldError("destino", "dest_destinatario", "Destinatario duplicado para su agencia");
                } else {
                       error = new FieldError("destino", "dest_destinatario", "error no controlado: " + e.getMessage());
                }
                
                result.addError(error);
        
                return "destinoForm";
                
         } 
			
		
	}
	
	@RequestMapping(value = "/destinoLista&id={id}/eliminar", method = RequestMethod.POST)
	@ResponseBody
	public String eliminarDeLista(@PathVariable("id") Integer id){
		
		Destino destino = destinoService.buscarDestino(id);
		
		try{
			destinoService.eliminar(destino);
			return "ok";			
		}catch(Exception e){			
			return "error";			
		}
	}
	
}