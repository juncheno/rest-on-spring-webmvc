package com.gupao.vip.restonspringwebmvc.http.message;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.gupao.vip.restonspringwebmvc.domain.Person;
  /**
   * person 自描述消息处理
   * @author Administrator
   *
   */
public class PropertiesPersonHttpMessageConverter  extends AbstractHttpMessageConverter<Person>{
    
	public PropertiesPersonHttpMessageConverter(){
		super(MediaType.valueOf("application/properties+person"));
		setDefaultCharset(Charset.forName("UTF-8"));
	}
	
	//必须是person的子类
	@Override
	protected boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(Person.class);
	}
    /**
     * 将请求中properties 内容转换成 Person对象
     */
	@Override
	protected Person readInternal(Class<? extends Person> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		    /**
		     * person.id = 1
             * person.name = chenjun
		     */
            InputStream inputStream=inputMessage.getBody();
            Properties properties=new Properties();
            //将请求中内容转化成properties
            properties.load(new InputStreamReader(inputStream, getDefaultCharset()));
            //将properties中内容转化到person对象字段中
            Person person=new Person();
            person.setId(Long.valueOf(properties.getProperty("person.id")));
            person.setName(properties.getProperty("person.name"));
            
		return person;
	}
 
	@Override
	protected void writeInternal(Person t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
            OutputStream outputStream=outputMessage.getBody();
            
            Properties properties=new Properties();
            properties.setProperty("person.id", String.valueOf(t.getId()));
            properties.setProperty("person.name",t.getName());
            
            properties.store(new OutputStreamWriter(outputStream,getDefaultCharset()), "Written by web server");
	}

	


}
