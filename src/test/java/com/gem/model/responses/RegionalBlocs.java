package com.gem.model.responses;

import java.util.List;

public class RegionalBlocs {
	
	public RegionalBlocs() {
		
	}
	
	private List<String> otherNames;

	private String acronym;

	private String name;

	private List<String> otherAcronyms;

	public List<String> getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(List<String> otherNames) {
		this.otherNames = otherNames;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getOtherAcronyms() {
		return otherAcronyms;
	}

	public void setOtherAcronyms(List<String> otherAcronyms) {
		this.otherAcronyms = otherAcronyms;
	}

	@Override
	public String toString() {
		return "RegionalBlocs [otherNames=" + otherNames + ", acronym=" + acronym + ", name=" + name
				+ ", otherAcronyms=" + otherAcronyms + "]";
	}

}
