package com.cognizant.spring;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring.model.Country;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringLearnApplication
{
	public static void main(String[] args)
	{
		displayCountry();
		SpringApplication.run(SpringLearnApplication.class, args);
	}
	
	public static void displayDate()
	{
		log.info("START");
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext();
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		
		try
		{  
			String strDate = "31/12/2018";
	        Date date = (Date) format.parse(strDate);
	        log.debug(format.toString().formatted(date));
	        log.debug(strDate);
	    }
		catch (ParseException e)
		{
			e.printStackTrace();
		}  
		log.info("END");
	}
	
	public static void displayCountry()
	{
		log.info("START of displayCountry()");
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		@SuppressWarnings("unchecked")
		List<Country> countries = (List<Country>) context.getBean("countryList");
		
		for(Country country: countries)
		{	
			log.debug("{} as with short name {}.",country.getName(),country.getName());
		}
		log.info("END of displayCountry()");
	}
}
