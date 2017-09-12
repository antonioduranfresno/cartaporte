package net.gefco.cartaporte.controladores;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.Camion;
import net.gefco.cartaporte.modelo.CartaPorte;
import net.gefco.cartaporte.modelo.CompaniaTransporte;
import net.gefco.cartaporte.modelo.Conductor;
import net.gefco.cartaporte.modelo.Usuario;
import net.gefco.cartaporte.negocio.AgenciaService;
import net.gefco.cartaporte.negocio.CamionService;
import net.gefco.cartaporte.negocio.CartaPorteService;
import net.gefco.cartaporte.negocio.CompaniaTransporteService;
import net.gefco.cartaporte.negocio.ConductorService;
import net.gefco.cartaporte.util.CfgUtil;
import net.gefco.cartaporte.util.Form;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


@Controller
@SessionAttributes("usuarioSesion")
public class CartaPorteController {
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	private CartaPorteService cartaPorteService;
	
	@Autowired
	private ConductorService conductorService;
	
	@Autowired
	private CompaniaTransporteService companiaTransporteService;
	
	@Autowired
	private CamionService camionService;
	
	@Autowired
	private AgenciaService agenciaService;
	
	@RequestMapping(value = "/cartaPorteForm", method = RequestMethod.GET)
	public String mostrarFormulario(Model model, @RequestParam(value="idCartaPorte") Integer idCartaPorte){
		
		Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
		
		CartaPorte cartaPorte = cartaPorteService.buscarCartaPorte(idCartaPorte);
		
		model.addAttribute("cartaPorte", cartaPorte);
		
		model.addAttribute("listaCompaniasTransporte", companiaTransporteService.listarCompaniasTransporte(usuarioSesion.getAgencia()));
		
		//OJO: Esto depende realmente de la compan�a de transporte seleccionada por el usuario; 
		//Por defecto vienen los datos de la compania asociada a la ruta
		model.addAttribute("listaConductores", conductorService.listarConductores(cartaPorte.getCompaniaTransporte()));
		model.addAttribute("listaCamionesTractores", camionService.listarCamionesTractores(cartaPorte.getCompaniaTransporte()));
		model.addAttribute("listaCamionesNoTractores", camionService.listarCamionesNoTractores(cartaPorte.getCompaniaTransporte()));
		
		return "cartaPorteForm";
	}
	
	@RequestMapping(value = "/cartaPorteForm/selCompania={idCompaniaTransporte}") 
	@ResponseBody 
	public String seleccionCompania(@PathVariable("idCompaniaTransporte") Integer idCompaniaTransporte){
	
		CompaniaTransporte companiaTransporteEfectiva = companiaTransporteService.buscarCompaniaTransporte(idCompaniaTransporte);
		
		Gson 					gson 						= new Gson(); 
		JsonObject 				myObj 						= new JsonObject();
				
		StringBuilder cadenaConductores = new StringBuilder();
		
		cadenaConductores.append("<option value='0'>Selecci�n</option>");
		
		for(Conductor conductor : conductorService.listarConductores(companiaTransporteEfectiva)){		
			cadenaConductores.append("<option value='"+conductor.getId()+"'>"+conductor.getCond_nombre()+"</option>");			
		}
		
		StringBuilder cadenaCamionesTractores = new StringBuilder();
		
		cadenaCamionesTractores.append("<option value='0'>Selecci�n</option>");
		
		for(Camion camion : camionService.listarCamionesTractores(companiaTransporteEfectiva)){		
			cadenaCamionesTractores.append("<option value='"+camion.getCami_matricula()+"'>"+camion.getCami_matricula()+"</option>");			
		}
		
		StringBuilder cadenaCamionesNoTractores = new StringBuilder();
		
		cadenaCamionesNoTractores.append("<option value='0'>Selecci�n</option>");
		
		for(Camion camion : camionService.listarCamionesNoTractores(companiaTransporteEfectiva)){		
			cadenaCamionesNoTractores.append("<option value='"+camion.getCami_matricula()+"'>"+camion.getCami_matricula()+"</option>");			
		}
		
		JsonElement				jsCompaniaEfectiva			= gson.toJsonTree(companiaTransporteEfectiva);
		JsonElement				jsListaConductores			= gson.toJsonTree(cadenaConductores.toString());
		JsonElement				jsListaCamionesTractores	= gson.toJsonTree(cadenaCamionesTractores.toString());
		JsonElement				jsListaCamionesNoTractores	= gson.toJsonTree(cadenaCamionesNoTractores.toString());
		
		myObj.add("companiaEfectiva", jsCompaniaEfectiva);
		myObj.add("listaConductores", jsListaConductores);		
		myObj.add("listaCamionesTractores", jsListaCamionesTractores);
		myObj.add("listaCamionesNoTractores", jsListaCamionesNoTractores);
		
		return myObj.toString();		
	}
	
	@RequestMapping(value = "/cartaPorteForm/selConductor={idConductor}") 
	@ResponseBody 
	public String seleccionConductor(@PathVariable("idConductor") Integer idConductor){
	
		Conductor conductor = conductorService.buscarConductor(idConductor);
		
		SimpleDateFormat		sdf							= new SimpleDateFormat("dd/MM/yyyy");
		
		Gson 					gson 						= new Gson(); 
		JsonObject 				myObj 						= new JsonObject();		
		
		JsonElement				jsConductor					= gson.toJsonTree(conductor);
		JsonElement				jsFechaExpedicion			= gson.toJsonTree(sdf.format(conductor.getCond_fechaExpedicion()));
		
		myObj.add("conductor", jsConductor);
		myObj.add("fechaExpedicion", jsFechaExpedicion); //La paso aparte porque desde JSON no puedo acceder a m�todos, solo a propiedades
		
		return myObj.toString();
	}
	
	@RequestMapping(value = "/cartaPorteForm", method = RequestMethod.POST, params="action=Aceptar")
	public String aceptar(Model model, @ModelAttribute("cartaPorte") @Valid CartaPorte cartaPorte, @ModelAttribute("reutilizar") String reutilizar,
			BindingResult result){
		
		if(cartaPorte.getCompaniaTransporte().getId()==0){			
			FieldError error = new FieldError("cartaPorte", "companiaTransporte.id", "!");			
			result.addError(error);			
		}
		
		if(cartaPorte.getConductor().getId()==0){			
			FieldError error = new FieldError("cartaPorte", "conductor.id", "!");			
			result.addError(error);			
		}
		
		if(cartaPorte.getCapo_matriculaTractora().equals("0")){
			FieldError error = new FieldError("cartaPorte", "capo_matriculaTractora", "!");			
			result.addError(error);
		}
		
		if(cartaPorte.getCapo_matriculaRemolque().equals("0")){
			FieldError error = new FieldError("cartaPorte", "capo_matriculaRemolque", "!");			
			result.addError(error);
		}
		
		if(!result.hasErrors()){			
			
			try{
				
				if(reutilizar.equals("on")){
					
					for(CartaPorte carta : cartaPorteService.listarCartasPendientesRuta(cartaPorte.getCapo_secuenciaRuta())){
						
						carta.setCapo_numeroCarta(""); 
						carta.setConductor(cartaPorte.getConductor());
						carta.setCapo_telefonoConductor(cartaPorte.getCapo_telefonoConductor());
						carta.setCapo_matriculaTractora(cartaPorte.getCapo_matriculaTractora());
						carta.setCapo_matriculaRemolque(cartaPorte.getCapo_matriculaRemolque());
						
						cartaPorteService.actualizar(carta);
					}
					
				}
				
				return "redirect:/cartaPortePendienteLista?secRuta="+cartaPorte.getCapo_secuenciaRuta()+"&success=true";
				
			} catch (Exception e) {
				
				FieldError error = new FieldError("cartaPorte", "precinto", "error no controlado: " + e.getMessage());				
				result.addError(error);
				
				return "cartaPorteForm";
			} 
		}

		model.addAttribute("cartaPorte", cartaPorte);		
		model.addAttribute("listaCompaniasTransporte", companiaTransporteService.listarCompaniasTransporte(cartaPorte.getAgencia()));		
		model.addAttribute("listaConductores", conductorService.listarConductores(cartaPorte.getCompaniaTransporte()));
		model.addAttribute("listaCamionesTractores", camionService.listarCamionesTractores(cartaPorte.getCompaniaTransporte()));
		model.addAttribute("listaCamionesNoTractores", camionService.listarCamionesNoTractores(cartaPorte.getCompaniaTransporte()));
		
		return "cartaPorteForm";
	}
	
	//CONTROLAR EL ARGUMENTO DE VUELTA
	
	@RequestMapping(value = "/cartaPortePendienteLista&id={idCartaPorte}/eliminar", method = RequestMethod.POST)
	public String eliminarDeLista(@PathVariable("idCartaPorte") Integer idCartaPorte){
		
		CartaPorte cartaPorte = cartaPorteService.buscarCartaPorte(idCartaPorte);
		
		cartaPorteService.eliminar(cartaPorte);
		
		return "cartaPortePendienteLista";
	}

	//CONTROLAR EL ARGUMENTO DE VUELTA
	
    @RequestMapping("/cartaPorteEmitidaLista")
    public String mostrarSeleccionCartasEmitidas(Model model, @ModelAttribute("listaIds") ArrayList<Integer> listaIds){
          
    	Usuario usuarioSesion = (Usuario) model.asMap().get("usuarioSesion");
      
    	List<CartaPorte> listaCartasEmitidas = cartaPorteService.listarCartasEmitidas(usuarioSesion.getAgencia());
 
    	model.addAttribute("listaCartasEmitidas", listaCartasEmitidas);
  
    	if(listaIds!=null){
    		model.addAttribute("listaIds", listaIds.toString().replace("[", "").replace("]",""));
    	}
    	
    	return "cartaPorteEmitidaLista";
    
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/cartaPorteForm&id={idCartaPorte}/informe", method = RequestMethod.GET)
	public void descargarCartaPorte(Model model, @PathVariable("idCartaPorte") Integer idCartaPorte, HttpServletResponse response) throws ServletException{

		CartaPorte cartaPorte = cartaPorteService.buscarCartaPorte(idCartaPorte);
		
		Agencia agencia = agenciaService.buscarAgencia(cartaPorte.getAgencia().getId());
		
        try {
        	
        	@SuppressWarnings("rawtypes")
			Map parametros = new HashMap();
			        	
        	parametros.put("rutaImagenes", servletContext.getRealPath("/resources/reports/imagenes/"));
			parametros.put("IdCartaPorte", cartaPorte.getId());
		    
			String ruta 	= servletContext.getRealPath("/resources/reports/CartaPorte.jasper");
			
			JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);
			
			JasperPrint jasperBase  = null;			
			JasperPrint jasperAux   = null;
			
			if (agencia.getAgen_copiaOrigen()){
				
				parametros.put("destinatario", "EJEMPLAR PARA CENTRO ORIGEN");
				jasperBase = JasperFillManager.fillReport(reporte,parametros, DriverManager.getConnection(CfgUtil.URL_BBDD,CfgUtil.USR_BBDD,CfgUtil.PW_BBDD));
			}
			
			if (agencia.getAgen_copiaDestino()){
				
				parametros.put("destinatario", "EJEMPLAR PARA AGENCIA DESTINATARIA");				
				
				if(jasperBase==null){				
					jasperBase = JasperFillManager.fillReport(reporte,parametros, DriverManager.getConnection(CfgUtil.URL_BBDD,CfgUtil.USR_BBDD,CfgUtil.PW_BBDD));					
				}else{					
					jasperAux = JasperFillManager.fillReport(reporte,parametros, DriverManager.getConnection(CfgUtil.URL_BBDD,CfgUtil.USR_BBDD,CfgUtil.PW_BBDD));
					jasperBase.addPage(jasperBase.getPages().size(), (JRPrintPage) jasperAux.getPages().get(0));	
				}				
			}
			
			if (agencia.getAgen_copiaTransportista()){	
				
				parametros.put("destinatario", "EJEMPLAR PARA COMPA��A DE TRANSPORTES");
				
				if(jasperBase==null){					
					jasperBase = JasperFillManager.fillReport(reporte,parametros, DriverManager.getConnection(CfgUtil.URL_BBDD,CfgUtil.USR_BBDD,CfgUtil.PW_BBDD));					
				}else{					
					jasperAux = JasperFillManager.fillReport(reporte,parametros, DriverManager.getConnection(CfgUtil.URL_BBDD,CfgUtil.USR_BBDD,CfgUtil.PW_BBDD));
					jasperBase.addPage(jasperBase.getPages().size(), (JRPrintPage) jasperAux.getPages().get(0));	
				}				
			}
			
			if (agencia.getAgen_copiaFactura()){		
				
				parametros.put("destinatario", "EJEMPLAR PARA DEVOLVER CON FACTURA");				

				if(jasperBase==null){					
					jasperBase = JasperFillManager.fillReport(reporte,parametros, DriverManager.getConnection(CfgUtil.URL_BBDD,CfgUtil.USR_BBDD,CfgUtil.PW_BBDD));
				}else{					
					jasperAux = JasperFillManager.fillReport(reporte,parametros, DriverManager.getConnection(CfgUtil.URL_BBDD,CfgUtil.USR_BBDD,CfgUtil.PW_BBDD));
					jasperBase.addPage(jasperBase.getPages().size(), (JRPrintPage) jasperAux.getPages().get(0));	
				}				
			}
			
			OutputStream os = response.getOutputStream();
			
			byte[] bits = JasperExportManager.exportReportToPdf(jasperBase);
			
			response.setHeader("Cache-Control", "max-age=0");
			response.setHeader("Content-disposition", "attachment; filename=CartaPorte.pdf");
			response.setContentType("application/pdf");
			response.setContentLength(bits.length);
			response.setCharacterEncoding("UTF-8");
			
			os.write(bits);
			os.flush();

		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
		
	@RequestMapping(value = "/cartaPortePendienteLista", method = RequestMethod.POST, params="GenerarCartasPorte")
	public String generarCartasPorte(Model model, @ModelAttribute("form") Form form, HttpServletRequest request, 
			HttpServletResponse response, RedirectAttributes ra){

		List<CartaPorte> listaActualizar = new ArrayList<CartaPorte>();
		
		for (Entry<Integer, Boolean> e: form.getMapa().entrySet()) {
			
			CartaPorte carta = cartaPorteService.buscarCartaPorte(e.getKey());
			
			if (e.getValue() == null) {
				e.setValue(false);
			}else{
				
				//1) VERIFICACI�N: Si hemos pasado por la edici�n de la carta de porte, el numeroCarta es "";
				if(carta.getCapo_numeroCarta()!=null){ 
			
					listaActualizar.add(carta);
					
				}else{
					listaActualizar.clear();
					return "redirect:/cartaPortePendienteLista?secRuta="+carta.getCapo_secuenciaRuta()+"&success=false";
				}
				
			}
			
		}
		
		if(listaActualizar.size()>0){
			
			List<Integer> listaIds = new ArrayList<Integer>();
			
			for(CartaPorte carta : listaActualizar){
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
				
				String anyo = sdf.format(carta.getCapo_fechaDocumentacion());
				
				carta.setCapo_emitida(true);
				carta.setCapo_numeroCarta(cartaPorteService.calculaNumeroCarta(carta.getAgencia(), new Integer(anyo)));
				cartaPorteService.actualizar(carta);
				
				listaIds.add(carta.getId());
			}
			
			ra.addFlashAttribute("listaIds", listaIds);
			return "redirect:/cartaPorteEmitidaLista";
			
		}else{		
			
			if(request.getParameter("secRuta")!=null){
				return "redirect:/cartaPortePendienteLista?secRuta="+request.getParameter("secRuta");
			}else{						
				return "redirect:/cartaPortePendienteLista";	
			}
			
		}		
		
	}
	
}