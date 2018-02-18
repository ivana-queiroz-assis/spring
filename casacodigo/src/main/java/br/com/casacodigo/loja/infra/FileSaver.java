package br.com.casacodigo.loja.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

	@Autowired
	private HttpServletRequest request;
	
	public String write(String src, MultipartFile file) {
		String path="";
		try {
			String realPath=request.getServletContext().getRealPath("/"+src);			
			path = realPath+"/"+file.getOriginalFilename();			
			file.transferTo(new File(path));
			
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return src+"/"+file.getOriginalFilename(); 
		
	}
}
