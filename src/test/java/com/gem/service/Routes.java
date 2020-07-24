package com.gem.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class conatins all routes of the application. Making it easy to
 * configure all routes at one place in case any change happens in build or
 * routes.
 */
public class Routes {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Routes.class);

	private static final String ALL_COUNTRIES = "/all";
	private static final String VERSION = "/v2";

	/** Endpoint for getting all countries
	 * @return String [e.g  https://restcountries.eu/rest/v2/all]
	 */
	public static String allCountries() {
		return VERSION + ALL_COUNTRIES;

	}
}
