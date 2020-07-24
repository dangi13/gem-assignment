package com.gem.tests;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.gem.model.responses.Country;
import com.gem.service.CountryService;
import com.gem.service.DbService;
import com.gem.validators.CountryValidator;

/**
 * This class contains all test cases related to Country data.
 */
public class CountryTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryTest.class); // for log capturing (if required)
	
	@Test(testName = "TC01", description = "All Countries for which Capital data is missing in table.")
	public void list_missing_countries() {
		// arrange  // act
		List<String> countriesInAPIResponse = CountryService.getCountries().stream()
															.map(country -> country.getName())
															.collect(Collectors.toList());
		List<String> countriesInDB = DbService.getAllCountryDetails()
												 .entrySet()
												 .stream()
												 .map(country -> country.getValue().get("Country"))
												 .collect(Collectors.toList());

		// assert
		CountryValidator.validateMissingCountriesInTable(countriesInAPIResponse, countriesInDB);

	}

	@Test(testName = "TC02", description = "All Country details for which Capital and Currency data is different in table and API.")
	public void validate_mismatched_currencyAndCapitals() {
		
		// assert
		CountryValidator.validateCapitalAndCurrency(CountryService.getCountries(), DbService.getAllCountryDetails());
	}

	@Test(testName = "TC03", description = "Check whether country which has maximum number of countries bordering with are same or not between API and DB ")
	public void validate_maxBorders() {
		
		// arrange
		Country countryWithMaxBordersAPI = CountryService.getCountries()
														  .stream()
														  .max(Comparator.comparingInt(country -> country.getBorders().size()))
														  .get();	
		
		// act
		Map<String,String> maxBorderDetailsDB = DbService.getMaxBordersCountry();
				
		// assert
		CountryValidator.validateMaxBorders(countryWithMaxBordersAPI, maxBorderDetailsDB);
	}

}
