package com.gem.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gem.listeners.ExtentReporter;
import com.gem.model.responses.Country;
import com.gem.utils.db.DbConnector;

/** It contains all the queries and their results stored in expected format.
 * @author Jaikant.lnu
 *
 */
public class DbService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DbService.class);
	public static Connection con;

	static {
		con = DbConnector.getDbConnection();
	}

	/** It will insert the countries in table : countries
	 * @param countries : List<Country> from API response
	 */
	public static void insertCountries(List<Country> countries) {
		PreparedStatement stmt;
		String query = "insert IGNORE into countries (C_ID,Country,Capital,Currency_Code) VALUES(?,?,?,?)";
		try {
			for (Country country : countries) {
				stmt = con.prepareStatement(query);
				stmt.setString(1, country.getAlpha3Code());
				stmt.setString(2, country.getName());
				stmt.setString(3, country.getCapital());
				stmt.setString(4, country.getCurrencies().get(0).getCode());
				stmt.executeUpdate();
			}
			ExtentReporter.pass("Query Executed: " + query); 
			LOGGER.info("Finsihed inserting countries in table : countries");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/** It will add borders from all countries in table : borders
	 * @param countries  : List<Country> from API response
	 */
	public static void insertBorders(List<Country> countries) {
		try {
			PreparedStatement stmt = null;
			String query = "insert ignore into borders (C_ID,B_ID) VALUES(?,?)";

			for (Country country : countries) {
				String countryCode = country.getAlpha3Code();
				for (String border : country.getBorders()) {
					stmt = con.prepareStatement(query);
					stmt.setString(1, countryCode);
					stmt.setString(2, border);
					stmt.executeUpdate();
				}
			}
			ExtentReporter.pass("Query Executed: " + query); 
			LOGGER.info("Finsihed inserting borders in table : borders");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/** It will get all country details/rows from table : countries
	 * @return Map<String, Map<String,String>>
	 * 		{
	 *       {C_ID, {C_ID=CHN, Capital=ANY, Country = CHINA, Currency_Code = ANYCODE}}
	 		 {C_ID, {C_ID=BNI, Capital=ANY, Country = BERMUDA, Currency_Code = BHR}}
	 		}
	 */
	public static Map<String, Map<String, String>> getAllCountryDetails() {
		String query = "SELECT * FROM countries;";
		Map<String, Map<String, String>> countryMap = new LinkedHashMap<>();
		try {
			ResultSet rs = con.createStatement().executeQuery(query);
			ExtentReporter.pass("Query Executed: " + query); 
			ResultSetMetaData metadata = rs.getMetaData();
			int columnCount = metadata.getColumnCount();
			List<String> columnNames = new LinkedList<>();
			int columnIndex = 0;
			while (columnIndex < columnCount) {
				columnIndex ++;
				columnNames.add(metadata.getColumnName(columnIndex));
			}

			while (rs.next()) {
				String countryId = rs.getString("C_ID");
				Map<String, String> rowData = new LinkedHashMap<>();
				for (int column = 0; column < columnNames.size(); column++) {
					String columnName = columnNames.get(column);
					String columnValue = rs.getString(columnNames.get(column));
					rowData.put(columnName, columnValue);
				}
				countryMap.put(countryId, rowData);
			}
		} catch (SQLException e) {
			System.out.println("Error while executing query : " + query);
			e.printStackTrace();
		}

		return countryMap;
	}
	
	/** It will return the detail of country which has maximum borders
	 * @return Map : [e.g {C_ID=CHN, borderCount=15}]
	 */
	public static Map<String, String> getMaxBordersCountry() {
		String query = "SELECT C_ID, COUNT(*) AS borderCount FROM db_countries.borders GROUP BY C_ID order by borderCount desc limit 0,1;";
		Map<String, String> resultMap = new HashMap<>();
		try {
			ResultSet rs = con.createStatement().executeQuery(query);
			ExtentReporter.pass("Query Executed: " + query); 
			rs.next();
			resultMap.put("C_ID", rs.getString("C_ID"));
			resultMap.put("borderCount", rs.getString("borderCount"));
		} catch (SQLException e) {
			ExtentReporter.fail("Error while executing query : " + query);
		}

		return resultMap;
	}

}
