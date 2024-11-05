package com.sp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.sp.service.GeographicPlaces;

@Service
public class GeographicPlacesImpl implements GeographicPlaces{

	private RestClient client;
	
	@Value("${RAPID_API_KEY}")
	private String rapidApiKey;
	
	public GeographicPlacesImpl(RestClient.Builder restClientBuilder) {
		this.client = restClientBuilder.baseUrl("https://country-state-city-search-rest-api.p.rapidapi.com").build();
	}
	
	@Override
	public Map<String, Object> getStatesByCountyCode(String code) throws Exception{
		Map<String, Object> data = null;
		try {
			StringBuffer strb = new StringBuffer();
			strb.append("/states-by-countrycode?countrycode=").append(code);
			List<Map<String, String>> list = this.client.get().uri(strb.toString()).header("x-rapidapi-key", this.rapidApiKey).retrieve().body(List.class);
			data = new HashMap<String, Object>();
			data.put("data", list);
		}catch(Exception e) {
			throw new Exception("Exception in \"getStatesByCountyCode\" "+e.getMessage());
		}
		return data;
	}

	@Override
	public Map<String, Object> getCountyInfo(String code) throws Exception {
		Map<String, Object> data = null;
		try {
			StringBuffer strb = new StringBuffer();
			strb.append("/country-data-by-countrycode?countrycode=").append(code);
			data = this.client.get().uri(strb.toString()).header("x-rapidapi-key", this.rapidApiKey).retrieve().body(Map.class);
		}catch(Exception e) {
			throw new Exception("Exception in \"getCountyInfo\" "+e.getMessage());
		}
		return data;
	}

}
