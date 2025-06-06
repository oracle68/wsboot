package com.wsboot;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

import com.wsboot.util.ColumnNames;


@SpringBootApplication

public class WsbootApplication  {



    @Autowired(required = false)
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.setOrder(1);
    }
	
	public static void main(String[] args) throws IOException {
		/*ResourceHandlerRegistry registry;
		 registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	     registry.setOrder(1);
	   */     
	    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
	    resolver.setApplicationContext(new AnnotationConfigApplicationContext());
	    resolver.setPrefix("classpath:/templates/");
	    resolver.setSuffix(".html");
	    resolver.setCharacterEncoding("UTF-8");
	    resolver.setTemplateMode(TemplateMode.HTML);

	    SpringTemplateEngine engine = new SpringTemplateEngine();
	    engine.setTemplateResolver(resolver);

	    Context context = new Context();
	   // String html = engine.process("index", context);
	   // System.out.println(html);	
	    	    
		SpringApplication.run(WsbootApplication.class, args);
		//String url = "http://localhost:9999/EmpsListProvincia";
		//String url = "http://localhost:9999/execSqlTable?table=Empleados";
		//String url = "http://localhost:9999/bookPage?pageNo=2&pageSize=10";
		//String url = "http://localhost:9999/ListToPdf2?tabla=Empleados";
		String url = "http://localhost:9999/CombosLists";
		
		openbrowser op = new openbrowser();
		op.openbrowser(url);

		
		
		//String url2 = "http://localhost:9999/EmpsListToXML";
		//openbrowser op2 = new openbrowser();
		//op2.openbrowser(url2);		

	}

}
