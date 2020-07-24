package com.gem.model.responses;

import java.util.List;

public class Country {
	
	public Country() {
		
	}

	private String area;

	private String nativeName;

	private String capital;

	private String demonym;

	private String flag;

	private String alpha2Code;

	private List<Languages> languages;

	private List<String> borders;

	private String subregion;

	private List<String> callingCodes;

	private List<RegionalBlocs> regionalBlocs;

	private String gini;

	private String population;

	private String numericCode;

	private String alpha3Code;

	private List<String> topLevelDomain;

	private List<String> timezones;

	private String cioc;

	private Translations translations;

	private String name;

	private List<String> altSpellings;

	private String region;

	private List<String> latlng;

	private List<Currencies> currencies;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getNativeName() {
		return nativeName;
	}

	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getDemonym() {
		return demonym;
	}

	public void setDemonym(String demonym) {
		this.demonym = demonym;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getAlpha2Code() {
		return alpha2Code;
	}

	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}

	public List<Languages> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Languages> languages) {
		this.languages = languages;
	}

	public List<String> getBorders() {
		return borders;
	}

	public void setBorders(List<String> borders) {
		this.borders = borders;
	}

	public String getSubregion() {
		return subregion;
	}

	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}

	public List<String> getCallingCodes() {
		return callingCodes;
	}

	public void setCallingCodes(List<String> callingCodes) {
		this.callingCodes = callingCodes;
	}

	public List<RegionalBlocs> getRegionalBlocs() {
		return regionalBlocs;
	}

	public void setRegionalBlocs(List<RegionalBlocs> regionalBlocs) {
		this.regionalBlocs = regionalBlocs;
	}

	public String getGini() {
		return gini;
	}

	public void setGini(String gini) {
		this.gini = gini;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getNumericCode() {
		return numericCode;
	}

	public void setNumericCode(String numericCode) {
		this.numericCode = numericCode;
	}

	public String getAlpha3Code() {
		return alpha3Code;
	}

	public void setAlpha3Code(String alpha3Code) {
		this.alpha3Code = alpha3Code;
	}

	public List<String> getTopLevelDomain() {
		return topLevelDomain;
	}

	public void setTopLevelDomain(List<String> topLevelDomain) {
		this.topLevelDomain = topLevelDomain;
	}

	public List<String> getTimezones() {
		return timezones;
	}

	public void setTimezones(List<String> timezones) {
		this.timezones = timezones;
	}

	public String getCioc() {
		return cioc;
	}

	public void setCioc(String cioc) {
		this.cioc = cioc;
	}

	public Translations getTranslations() {
		return translations;
	}

	public void setTranslations(Translations translations) {
		this.translations = translations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAltSpellings() {
		return altSpellings;
	}

	public void setAltSpellings(List<String> altSpellings) {
		this.altSpellings = altSpellings;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<String> getLatlng() {
		return latlng;
	}

	public void setLatlng(List<String> latlng) {
		this.latlng = latlng;
	}

	public List<Currencies> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<Currencies> currencies) {
		this.currencies = currencies;
	}

	@Override
	public String toString() {
		return "Countries [area=" + area + ", nativeName=" + nativeName + ", capital=" + capital + ", demonym="
				+ demonym + ", flag=" + flag + ", alpha2Code=" + alpha2Code + ", languages=" + languages + ", borders="
				+ borders + ", subregion=" + subregion + ", callingCodes=" + callingCodes + ", regionalBlocs="
				+ regionalBlocs + ", gini=" + gini + ", population=" + population + ", numericCode=" + numericCode
				+ ", alpha3Code=" + alpha3Code + ", topLevelDomain=" + topLevelDomain + ", timezones=" + timezones
				+ ", cioc=" + cioc + ", translations=" + translations + ", name=" + name + ", altSpellings="
				+ altSpellings + ", region=" + region + ", latlng=" + latlng + ", currencies=" + currencies + "]";
	}
	
}