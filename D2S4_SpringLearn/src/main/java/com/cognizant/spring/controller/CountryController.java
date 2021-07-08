package com.cognizant.spring.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.spring.model.Country;
import com.cognizant.spring.service.CountryService;
import com.cognizant.spring.controller.CountryController;

import lombok.extern.slf4j.Slf4j;

import com.cognizant.spring.exception.CountryNotFoundException;

@RestController
@RequestMapping("/countries")
@Slf4j
public class CountryController
{
	ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");

	@Autowired
	CountryService countryService;
	
	/*
	@GetMapping(value = "/country")
	public ResponseEntity<Country> getCountry()
	{
		log.info("Start getCountry()");
		Country c = (Country) ctx.getBean("in");
		log.info("End getCountry()");
		return new ResponseEntity<Country> (c,HttpStatus.OK);
	}
	*/
	
	@GetMapping
	public ResponseEntity<List<Country>> getCountries()
	{
		log.info("End getCountries()");
		
		@SuppressWarnings("unchecked")
		List<Country> list = (List<Country>) ctx.getBean("countryList");
		
		log.info("End getCountries()");
		return new ResponseEntity<List<Country>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<Country> getCountry(@PathVariable("code") String code) throws CountryNotFoundException
	{
		Country country=countryService.getCountry(code);
		if(country!=null)
		{
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
		throw new CountryNotFoundException();	
	}
	
	@PostMapping
	public Country addCountry(@RequestBody @Valid Country country)
	{
		log.info("Start addCountry()");
		
		/*
		ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
		Validator validator=(Validator) factory.getValidator();
		Set<ConstraintViolation<Country>> violations=validator.validate(country);
		List<String> errors=new ArrayList<String>();
		for(ConstraintViolation<Country> violation : violations)
		{
			errors.add(violation.getMessage());
		}
		if(errors.size()>0)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,errors.toString());
		}
		*/
		
		log.info(country.toString());
		log.info("End addCountry()");
		return country;
	}
	
	@PutMapping
	public Country updateCountry(@RequestBody Country country) throws CountryNotFoundException
	{
		log.info("Start");
		Country updated=countryService.updateCountry(country);
		log.info(updated.toString());
		log.info("End");
		return country;
	}
}
