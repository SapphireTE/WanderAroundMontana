package com.te.config;

import com.te.config.viewresolver.JsonViewResolver;
import com.te.extend.JsonViewHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mobile.device.DeviceHandlerMethodArgumentResolver;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("com.te.api")
@Import(SwaggerConfig.class)
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager){
        ContentNegotiatingViewResolver resolver=new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        List<ViewResolver> viewResolversImpl = new ArrayList<ViewResolver>(); //class type interface list
        viewResolversImpl.add(jsonViewResolver());
//        viewResolversImpl.add(xmlViewResolver());

        resolver.setViewResolvers(viewResolversImpl);
        return resolver;
    }

//    @Bean
//    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager){
//        ContentNegotiatingViewResolver resolver =new ContentNegotiatingViewResolver();
//        resolver.setContentNegotiationManager(manager);
//
//        List<ViewResolver> viewResolverImpl=new ArrayList<>();
//        viewResolverImpl.add(new JsonViewResolver());
//
//        resolver.setViewResolvers(viewResolverImpl);
//        return resolver;
//    }

    @Bean(name="multipartResolver")
    public CommonsMultipartResolver getMultipartResolver(){
        CommonsMultipartResolver resolver=new CommonsMultipartResolver();
        resolver.setMaxUploadSize(10008439);
        return resolver;
    }

    @Bean
    public DeviceHandlerMethodArgumentResolver deviceHandlerMethodArgumentResolver(){
        return new DeviceHandlerMethodArgumentResolver();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
        argumentResolvers.add(deviceHandlerMethodArgumentResolver());
    }

    @Bean
    public ViewResolver jsonViewResolver(){
        return new JsonViewResolver();
    }

//    @Bean
//    public DeviceHandlerMethodArgumentResolver deviceHandlerMethodArgumentResolver1(){
//        return new DeviceHandlerMethodArgumentResolver();
//    }
//
//    @Override
//    public void addArgumentResolvers1(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(deviceHandlerMethodArgumentResolver());
//    }

//    @Bean
//    public ViewResolver xmlViewResolver(){
//        return new XmlViewResolver();
//    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        JsonViewHttpMessageConverter jsonViewHttpMessageConverter = new JsonViewHttpMessageConverter();
        ResourceHttpMessageConverter resourceHttpMessageConverter = new ResourceHttpMessageConverter();
        converters.add(jsonViewHttpMessageConverter);
        converters.add(resourceHttpMessageConverter);
    }
}
