package com.gupao.vip.restonspringwebmvc.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gupao.vip.restonspringwebmvc.http.message.PropertiesPersonHttpMessageConverter;


  /**
	 * Web Mvc 配置
	 * @author Administrator
	 *
    */	
@Configuration
public class WebMvcConfig  implements WebMvcConfigurer{
    public  void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    	
    	
//    	converters.set(0, new MappingJackson2XmlHttpMessageConverter());
//    	converters.add(new MappingJackson2HttpMessageConverter());
	    
//    	System.err.println("converters :"+ converters );
    	
    	converters.add(new PropertiesPersonHttpMessageConverter());
	}
}
