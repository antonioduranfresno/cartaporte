package net.gefco.cartaporte.controladores;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import javax.validation.Valid;

import net.gefco.cartaporte.modelo.Entrega;
import net.gefco.cartaporte.modelo.Ruta;
import net.gefco.cartaporte.modelo.Usuario;
import net.gefco.cartaporte.negocio.CompaniaTransporteService;
import net.gefco.cartaporte.negocio.DestinoService;
import net.gefco.cartaporte.negocio.EntregaService;
import net.gefco.cartaporte.negocio.RutaService;
import net.gefco.cartaporte.negocio.TipoTransporteService;
import net.gefco.cartaporte.util.Form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuarioSesion")
public class RutaController {
	
	@Autowired
	private RutaService 				rutaService;
	
	@Autowired
	private CompaniaTransporteService 	companiaTransporteService;
	
	@Autowired
	private TipoTransporteService 		tipoTransporteService;
	
	@Autowired
	private DestinoService 				destinoService;
	
	@Autowired
	private EntregaService 				entregaService;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
		
	@RequestMapping(value = "/rutaLista", method = RequestMethod.GET)
	public String lista(Model model, @ModelAttribute("ruta") Ruta ruta){		
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");

		List<Ruta> listaRutas = new ArrayList<Ruta>();
        listaRutas = rutaService.listarRutas(usuarioSesion.getAgencia());

        Form f = new Form();
        
        for (Ruta r :  listaRutas) {
               f.getMapa().put(r.getId(), false);
        }
        
        model.addAttribute("form", f);
        model.addAttribute("listaRutas", listaRutas);		
		model.addAttribute("listaEntregas", entregaService.listarEntregasAgencia(usuarioSesion.getAgencia()));
				
		return "rutaLista";
	}
	
	
	//Tanto para crear nuevo Tipo como para visualizar existente; @RequestParam opcional 
	@RequestMapping(value = "/rutaForm", method = RequestMethod.GET)
	public String mostrarFormulario(Model model, @RequestParam(value="idRuta",required=false) Integer idRuta){
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		
		Ruta ruta = rutaService.buscarRuta(idRuta);
		
		if(idRuta!=null){
			model.addAttribute("ruta", ruta);	
			
			//Para cada entrega, es necesario la lista de destinos
			model.addAttribute("listaDestinos", destinoService.listarDestinos(usuarioSesion.getAgencia()));
			
			model.addAttribute("listaEntregas", entregaService.listarEntregas(ruta));
			
		}else{
			model.addAttribute("ruta", new Ruta());
			
		}
		
		model.addAttribute("entrega", new Entrega());
		
		model.addAttribute("listaCompaniasTransporte", companiaTransporteService.listarCompaniasTransporte(usuarioSesion.getAgencia()));
		model.addAttribute("listaTiposTransporte", tipoTransporteService.listarTiposTransporte(usuarioSesion.getAgencia()));
		
		return "rutaForm";
	}
	
	
	//Tanto para crear uno nuevo como para editar uno existente
	@RequestMapping(value = "/rutaForm", method = RequestMethod.POST, params="action=Aceptar")
	public String aceptar(Model model, @ModelAttribute("ruta") @Valid Ruta ruta, BindingResult result){
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		
		if(ruta.getCompaniaTransporte().getId()==0){			
			FieldError error = new FieldError("ruta", "companiaTransporte.id", "Por favor, seleccione una opci�n");			
			result.addError(error);			
		}

		if(ruta.getTipoTransporte().getId()==0){			
			FieldError error = new FieldError("ruta", "tipoTransporte.id", "Por favor, seleccione una opci�n");			
			result.addError(error);			
		}
		
		if(ruta.getRuta_horaDocumentacion()==null){
			FieldError error = new FieldError("ruta", "ruta_horaDocumentacion", "!");			
			result.addError(error);			
		}
		
		if(ruta.getRuta_horaSalida()==null){	
			FieldError error = new FieldError("ruta", "ruta_horaSalida", "!");			
			result.addError(error);			
		}

		if(!result.hasErrors()){			
			
			try{
				
				//Creaci�n
				if(ruta.getId()==null || ruta.getId()==0){
					
					ruta.setId(0);	
					ruta.setAgencia(usuarioSesion.getAgencia());
					
					rutaService.guardar(ruta);				
					
				//Actualizaci�n	
				}else{				
					rutaService.actualizar(ruta);				
				}
				
			} catch (Exception e) {
				
				FieldError error = new FieldError("ruta", "companiaTransporte.id", "error no controlado: " + e.getMessage());
				
				result.addError(error);     
				
			} 
		}
		
		model.addAttribute("entrega", new Entrega());		
		model.addAttribute("listaDestinos", destinoService.listarDestinos(usuarioSesion.getAgencia()));
		model.addAttribute("listaTiposTransporte", tipoTransporteService.listarTiposTransporte(usuarioSesion.getAgencia()));
        model.addAttribute("listaCompaniasTransporte", companiaTransporteService.listarCompaniasTransporte(usuarioSesion.getAgencia()));
		
		return "rutaForm";			
	}
	
	@RequestMapping(value = "/rutaLista&id={idRuta}/eliminar", method = RequestMethod.POST)
	public String eliminarDeLista(@PathVariable("idRuta") Integer idRuta){
		
		Ruta ruta = rutaService.buscarRuta(idRuta);
		
		rutaService.eliminar(ruta);
		
		return "rutaLista";
	}
	
	@RequestMapping(value = "/rutaLista", method = RequestMethod.POST, params="GenerarCartasPortePendientes")
	public String generarCartasPortePendientes(Model model, @ModelAttribute("form") Form form){
	
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		
		//Sustituir los valores nulos por falses
		for (Entry<Integer, Boolean> e: form.getMapa().entrySet()) {
			if (e.getValue() == null) {
				e.setValue(false);
			}
		}
		
		model.addAttribute("form", form);		
		model.addAttribute("listaRutas", rutaService.listarRutas(usuarioSesion.getAgencia()));
		model.addAttribute("listaEntregas", entregaService.listarEntregasAgencia(usuarioSesion.getAgencia()));
		
		return "rutaLista";
	}

	
	//Parte entrega
	@RequestMapping(value = "/rutaForm", method = RequestMethod.POST, params="entrega=Aceptar")
	public String aceptarEntrega(Model model, @ModelAttribute("entrega") @Valid Entrega entrega, BindingResult result){
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		
		Ruta ruta = rutaService.buscarRuta(entrega.getRuta().getId());
		
		if(entrega.getDestino().getId()==0){			
			FieldError error = new FieldError("entrega", "destino.id", "Por favor, seleccione una opci�n");			
			result.addError(error);			
		}
		
		if(entrega.getEntr_horaLlegada()==null){
			FieldError error = new FieldError("entrega", "entr_horaLlegada", "!");			
			result.addError(error);			
		}
		
		if(!result.hasErrors()){

			entrega.setId(0);							
			entregaService.guardar(entrega);				
			entrega = new Entrega(); //Para que se vac�en los valores de formulario Entrega
		}
		
		model.addAttribute("entrega", entrega);
		model.addAttribute("ruta", ruta);	
		model.addAttribute("listaEntregas", entregaService.listarEntregas(ruta));
		model.addAttribute("listaDestinos", destinoService.listarDestinos(usuarioSesion.getAgencia()));
		model.addAttribute("listaTiposTransporte", tipoTransporteService.listarTiposTransporte(usuarioSesion.getAgencia()));
        model.addAttribute("listaCompaniasTransporte", companiaTransporteService.listarCompaniasTransporte(usuarioSesion.getAgencia()));

        return "rutaForm";				
	}
	
	@RequestMapping(value = "/rutaForm&id={idEntrega}/eliminar", method = RequestMethod.POST)
	@ResponseBody //Devuelve el string literal (que usamos en JS), no redirige a la p�gina
	public String eliminarEntrega(@PathVariable("idEntrega") Integer idEntrega){
		
		Entrega entrega = entregaService.buscarEntrega(idEntrega);
		
		entregaService.eliminar(entrega);
		
		return "rutaForm?idRuta="+entrega.getRuta().getId();
		
	}
	
}