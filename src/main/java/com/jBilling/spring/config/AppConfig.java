package com.jBilling.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jBilling.spring.model.User;

@Configuration
@EnableWebMvc
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.jBilling.spring" })
public class AppConfig implements WebMvcConfigurer {
	@Autowired
	private Environment env;
	
	@Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
    @Bean
    public DataSource getDataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName(env.getProperty("db.driver"));
    	dataSource.setUrl(env.getProperty("db.url"));
    	dataSource.setUsername(env.getProperty("db.username"));
    	dataSource.setPassword(env.getProperty("db.password"));
    	return dataSource;
    }
    
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
    	LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
    	factoryBean.setDataSource(getDataSource());
    	
    	Properties props = new Properties();
    	props.put("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
    	props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
    	props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
    	factoryBean.setHibernateProperties(props);
    	factoryBean.setAnnotatedClasses(User.class);
    	return factoryBean;
    }
 
    
    @Bean
    public HibernateTransactionManager getTransactionManager() {
    	HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    	transactionManager.setSessionFactory(getSessionFactory().getObject());
    	return transactionManager;
    } 
    
    @Bean
    public MessageSource getMessageSource() {
    	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    	messageSource.setBasename("messages");
    	return messageSource;
    }
    
    public Validator getValidator() {
    	LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
    	validator.setValidationMessageSource(getMessageSource());
    	return validator;
    }
}
