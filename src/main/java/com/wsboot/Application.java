package com.wsboot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

public class Application {

  public static void main(String... args) {
    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
    resolver.setApplicationContext(new AnnotationConfigApplicationContext());
    resolver.setPrefix("classpath:/templates/");
    resolver.setSuffix(".html");
    resolver.setCharacterEncoding("UTF-8");
    resolver.setTemplateMode(TemplateMode.HTML);

    SpringTemplateEngine engine = new SpringTemplateEngine();
    engine.setTemplateResolver(resolver);

    Context context = new Context();
    String html = engine.process("index", context);
    System.out.println(html);
    new WsbootApplication();
  }
}

