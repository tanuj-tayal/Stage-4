package com.cognizant.spring.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring.exception.CountryNotFoundException;
import com.cognizant.spring.model.Country;

@Service
public class CountryService
{
	public Country getCountry(String code) throws CountryNotFoundException
	{
		@SuppressWarnings("resource")
		ApplicationContext context= new ClassPathXmlApplicationContext("country.xml");
		@SuppressWarnings("unchecked")
		List<Country> countries= context.getBean("countryList",java.util.ArrayList.class);
		for(Country c : countries)
		{
			if(c.getCode().equalsIgnoreCase(code))
			{
				return c;
			}
		}
		throw new CountryNotFoundException();
	}
	
	public Country updateCountry(Country country) throws CountryNotFoundException
	{
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		Country old=null;
		try
		{
			old=context.getBean(country.getCode().toLowerCase(),com.cognizant.spring.model.Country.class);
		}
		catch (Exception e)
		{
			throw new CountryNotFoundException();
		}	
		old.setName(country.getName());
		return old;
	}
}
