package com.gupao.vip.restonspringwebmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gupao.vip.restonspringwebmvc.domain.Person;

/**
 * {@link} {@link RestController} 
 * @author Administrator
 *
 */
@RestController
public class PersonRestController {
        @GetMapping("/person/{id}")
     public Person getPerson(@PathVariable Long id ,@RequestParam(required = false)
    		 String name){
        	Person person=new Person(); 
        	person.setId(id);
        	person.setName(name);
        	return person;
        }
        
        @PostMapping(value = "/person/json/to/properties" ,
        		consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,//请求类型
        		produces = "application/properties+person" )//相应类型
        public Person personJsonToProperties(@RequestBody Person person){
        	//@RequestBody 内容是Json
        	//相应内容是 properties
        	return person;
        }
        
        
        
        @PostMapping(value = "/person/properties/to/json" ,  //Accept
        		consumes = "application/properties+person" ,//请求类型 Content-Type
        		produces = MediaType.APPLICATION_JSON_UTF8_VALUE )//相应类型
        public Person personPropertiesToJson(@RequestBody Person person){
        	//@RequestBody 内容是 properties
        	//相应内容是 Json 
        	return person;
        }
}
