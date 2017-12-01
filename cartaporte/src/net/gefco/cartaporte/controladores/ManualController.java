package net.gefco.cartaporte.controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import net.gefco.cartaporte.util.CfgUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuarioSesion")
public class ManualController {
			
	private static final int BYTES_DOWNLOAD = 1024;
	
	@RequestMapping(value = "/manual", method = RequestMethod.GET)
	@SuppressWarnings("resource")
	public void devuelveManual(HttpServletResponse response) throws IOException{		
		
		File fichero = new File(CfgUtil.RUTA_MANUAL+"CartaPorte.pdf");
		
		 response.setHeader("Cache-Control", "max-age=0");
	     response.setHeader("Content-disposition", "attachment; filename=CartaPorte.pdf");
	     
		 InputStream is=new FileInputStream(fichero);
		 
		 int read=0;
		 byte[] bytes = new byte[BYTES_DOWNLOAD];
		 OutputStream os = response.getOutputStream();
		 while((read = is.read(bytes))!= -1){
		  os.write(bytes, 0, read);
		 }
		 os.flush();
		 os.close();
	}
	
	
	
}