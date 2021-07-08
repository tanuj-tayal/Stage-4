package com.cognizant.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/hello")
public class HelloController
{
	@GetMapping(value="")
	public ResponseEntity<String> sayHello()
	{
		log.info("Start of sayHello() method!");
		log.info("End of sayHello() method!");
		return new ResponseEntity<String>("Hello World!!", HttpStatus.OK);
	}
}
