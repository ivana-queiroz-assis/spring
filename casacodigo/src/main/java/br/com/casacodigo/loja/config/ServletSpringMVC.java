package br.com.casacodigo.loja.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	//Configuração JPA
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {AppWebConfig.class, JPAConfig.class};
	}

	//Mapear todas as requisições com barra
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	//Encoding UTF-8
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encondingFilter= new CharacterEncodingFilter();
		encondingFilter.setEncoding("UTF-8");
		return new Filter[] {encondingFilter};
	}
	//Config de envio de arquivo
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}
	
}
