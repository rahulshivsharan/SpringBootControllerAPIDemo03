package com.sp.service;

import java.util.Map;

public interface GeographicPlaces {
	Map<String, Object> getStatesByCountyCode(String code) throws Exception;
	Map<String, Object> getCountyInfo(String code) throws Exception;
}
