package com.cognizant.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring.model.Country;

@Service
public class CountryService
{
	private ApplicationContext ctx;

	public Country getCountry(String code)
	{
		List<String> presentCountry = new ArrayList<String>(Arrays.asList("in","us","de","jp"));
		
		if(presentCountry.indexOf(code)!=-1)
		{
			ctx = new ClassPathXmlApplicationContext("country.xml");
			Country country =  (Country) ctx.getBean(code.toLowerCase());
			return country;
		}	
		return null;
	}
}
