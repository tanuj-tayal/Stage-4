package com.cognizant.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring.model.Country;
import com.cognizant.spring.exception.CountryNotFoundException;
import com.cognizant.spring.service.CountryService;

@RestController
@RequestMapping(value="")
public class CountryController
{
ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
	
	@Autowired
	CountryService countryService;
	
	@GetMapping(value="/country")
	public ResponseEntity<Country> getCountryIndia()
	{
		Country countryIndia = (Country) ctx.getBean("in");
		return new ResponseEntity<Country> (countryIndia, HttpStatus.OK);
	}
	
	@GetMapping(value="/countries")
	public ResponseEntity<List<Country>> getAllCountries()
	{
		@SuppressWarnings("unchecked")
		List<Country> allCountries = (List<Country>) ctx.getBean("countryList");
		return new ResponseEntity<List<Country>>(allCountries, HttpStatus.OK);
	}
	
	@GetMapping(value="/countries/{code}")
	public ResponseEntity<Country> getCountry(@PathVariable("code") String code) throws CountryNotFoundException
	{
		Country country = countryService.getCountry(code);
		
		if(country!=null)
		{
			return new ResponseEntity<Country> (country, HttpStatus.OK);
		}
		throw new CountryNotFoundException();
	}
}
