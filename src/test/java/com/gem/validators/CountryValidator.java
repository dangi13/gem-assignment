package com.gem.validators;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.asserts.SoftAssert;

import com.gem.listeners.ExtentReporter;
import com.gem.model.responses.Country;

/** It contains all validations related to Country response.
 *
 */
public class CountryValidator {

	/** It will validate all missing countries in table when compared with API response.
	 * @param countriesInAPIResponse
	 * @param countriesInDB
	 */
	public static void validateMissingCountriesInTable(List<String> countriesInAPIResponse, List<String> countriesInDB) {
		System.out.println("Validating missing countries");
		countriesInAPIResponse.removeIf(x -> countriesInDB.contains(x));
		ExtentReporter.info("Data matched");
		ExtentReporter.info(countriesInAPIResponse.size() + " countries are missing in table");
		ExtentReporter.info(String.join(",", countriesInAPIResponse));
	}

	/** It will validate the Currency and Capital mismatch in DB and API response
	 * @param countries
	 * @param countryDetails
	 */
	public static void validateCapitalAndCurrency(List<Country> countryDataAPI, Map<String, Map<String,String>> countryDataDB) {
		ExtentReporter.info("Validating Capital and Currency mismatch ............");
		
		List<String> countriesInAPIResponse = countryDataAPI.stream().map(country -> country.getName()).collect(Collectors.toList());
		List<String> countriesInDatabase = countryDataDB.entrySet().stream().map(country -> country.getValue().get("Country")).collect(Collectors.toList());
		
		countriesInAPIResponse.retainAll(countriesInDatabase);  // validating only those countries that are present in DB and API both
		List<Country> filterdCountryAsInDb = countryDataAPI.stream().filter(country -> countriesInDatabase.contains(country.getName())).collect(Collectors.toList());
		
		// API capital and Currency
		Map<String, List<String>> apiCapitalAndCurrency = new HashMap<>();
		filterdCountryAsInDb.forEach(country -> apiCapitalAndCurrency.put(country.getName(), Arrays.asList(country.getCapital(),country.getCurrencies().get(0).getCode())));
		
		// DB capital and Currency
		Map<String, List<String>> dbCapitalAndCurrency = new HashMap<>();
		countryDataDB.values().forEach(values -> dbCapitalAndCurrency.put(values.get("Country"), Arrays.asList(values.get("Capital"),values.get("Currency_Code"))));
		
		// Unequal set of Currency and Capital
		Map<String,List<String>> unequalSet = dbCapitalAndCurrency.entrySet().stream().filter(item -> !item.getValue().equals(apiCapitalAndCurrency.get(item.getKey()))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		ExtentReporter.info("<hr style=\"height:6px;border:none;background-color:#FF5733;\" />");

		// displaying data in reports
		unequalSet.entrySet().forEach(item -> {
			String country  = item.getKey();
			String capitalInDb = item.getValue().get(0); 
			String capitalInAPIResponse = apiCapitalAndCurrency.get(item.getKey()).get(0);
			String currencyInDB = item.getValue().get(1);
			String currencyCodeInAPIResponse = apiCapitalAndCurrency.get(item.getKey()).get(1);

			ExtentReporter.info("<b>Country : " + new String(country.getBytes(Charset.forName("UTF-8"))) + "</b>" );  // displaying other language characters also
			
			if (!capitalInDb.equals(capitalInAPIResponse)) {
				ExtentReporter.info("Data : Capital");
				ExtentReporter.fail(" API Value: " + capitalInAPIResponse);
				ExtentReporter.fail(" DB Value: " + capitalInDb);
			}
				
			if (!currencyInDB.equals(currencyCodeInAPIResponse)) {
				ExtentReporter.info("Data : Currency");
				ExtentReporter.fail(" API Value: " + currencyCodeInAPIResponse);
				ExtentReporter.fail(" DB Value: " + currencyInDB);
			}
			ExtentReporter.info("<hr style=\"height:6px;border:none;background-color:#FF5733;\" />");
		});
		
		if (unequalSet.size() > 0) {
			throw new Error("Validation failed due to capital and country mismatch");   // just to mark test fail after displaying all mismatch values
		}
	}

	/** It will validate the country with max borders from API and DB response.
	 * @param actual : response from API
	 * @param expected : response from DB query
	 */
	public static void validateMaxBorders(Country actual, Map<String,String> expected) {
		ExtentReporter.info("Validating Maximum borders....");
		SoftAssert softAssert = new SoftAssert();
		
		String expectedCid = expected.get("C_ID");  // from DB
		String expectedBorderCount = expected.get("borderCount");  // from DB
		String actualCid = actual.getAlpha3Code();  // from API response
		int actuaBorderCount = actual.getBorders().size(); // from API response
		
		ExtentReporter.info("Max border in DB: [" + expectedCid + "," + expectedBorderCount + "]");
		ExtentReporter.info("Max border in API: [" + actualCid + "," + actuaBorderCount + "]");

		softAssert.assertEquals(actual.getAlpha3Code(), expected.get("C_ID"), "Country is different in API and DB with max borders");
		softAssert.assertEquals(actual.getBorders().size(), Integer.parseInt(expected.get("borderCount")), "Max borders count is different id DB and API");
		softAssert.assertAll();
		ExtentReporter.info("Validation successfull");

	}
}
