package com.chandu.restfileupload.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/responses")
public class ResponseEntityBuilder {
	@GetMapping(path="/codeAndBody", consumes="application/json", produces="text/plain")
		public ResponseEntity<String> codeAndBody() {
			String response = "Welcome to the API";
			return ResponseEntity.ok(response);
		}
		
	@GetMapping(path="/code", consumes="application/json", produces="text/plain")
	public ResponseEntity<HttpStatus> onlyCode() {
		String response = "Welcome to the API";
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(path="/CodeBodyHEeader", consumes="application/json", produces="text/plain")
	public ResponseEntity<String> noCodeAndBody() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("ChanduHeader", "Chandu");
		String response = "Checkout Http Headers and Http status also";
		return new ResponseEntity<String>(response,responseHeaders, HttpStatus.CREATED);
	}
	

}
