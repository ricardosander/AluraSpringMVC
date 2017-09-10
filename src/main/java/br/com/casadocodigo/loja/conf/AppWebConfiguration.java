package br.com.casadocodigo.loja.conf;

import br.com.casadocodigo.loja.controllers.HomeController;
import br.com.casadocodigo.loja.dao.ProdutoDAO;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class, ProdutoDAO.class})
public class AppWebConfiguration {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {

        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();

        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");

        return internalResourceViewResolver;
    }

    @Bean
    public MessageSource messageSource() {

        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;
        reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();

        reloadableResourceBundleMessageSource.setBasename("/WEB-INF/messages");
        reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
        reloadableResourceBundleMessageSource.setCacheSeconds(1);

        return reloadableResourceBundleMessageSource;
    }

    @Bean
    public FormattingConversionService mvcConversionService() {

        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

        DateFormatterRegistrar registra = new DateFormatterRegistrar();
        registra.setFormatter(new DateFormatter("dd/MM/yyyy"));
        registra.registerFormatters(conversionService);

        return conversionService;
    }

}
