package com.sp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.service.GeographicPlaces;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/fetch")
public class DataFetchController {
	
	@Autowired
	private GeographicPlaces geograpphicPlaces;

	@GetMapping("/hi")
	public Map<String, String> sayHi(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "Hello there");
		return map;
	}
	
	@GetMapping("/country/states/{countrycode}")
	public ResponseEntity<Map<String, Object>> getStatesByCountryCode(@PathVariable("countrycode") String code){
		Map<String, Object> map = null;
		try {
			map = this.geograpphicPlaces.getStatesByCountyCode(code);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK); 
		}catch(Exception e) {
			map = new HashMap<String, Object>();
			map.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/country/{countrycode}")
	public ResponseEntity<Map<String, Object>> getCountryByCountryCode(@PathVariable("countrycode") String code){
		Map<String, Object> map = null;
		try {
			map = this.geograpphicPlaces.getCountyInfo(code);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK); 
		}catch(Exception e) {
			map = new HashMap<String, Object>();
			map.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
