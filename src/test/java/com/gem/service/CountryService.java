package com.gem.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gem.listeners.ExtentReporter;
import com.gem.model.responses.Country;
import com.gem.utils.common.Config;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This is the API service class for all end point operations.
 */
public class CountryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
	private static final RequestSpecification request;

	static {
		RestAssured.baseURI = Config.getProperty("baseUrl");
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
	}

	/** It will give a list of all countries fetched form API.
	 * @return list of countries
	 */
	public static List<Country> getCountries() {
		Response response = request.get(Routes.allCountries());
		ExtentReporter.pass("API Executed : " + RestAssured.baseURI + Routes.allCountries());
		List<Country> countries = Arrays.asList(response.as(Country[].class));

		return countries;
	}

}