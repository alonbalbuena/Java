package com.dawes.ws;

public class Pais {
	
    private String continentEnglishName;
    private String countryEnglishName;
    private String provinceEnglishName;
    private int currentConfirmedCount;
    private int confirmedCount;
    private int curedCount;
    private long updateTime;
    
    
	public String getContinentEnglishName() {
		return continentEnglishName;
	}
	public void setContinentEnglishName(String continentEnglishName) {
		this.continentEnglishName = continentEnglishName;
	}
	public String getProvinceEnglishName() {
		return provinceEnglishName;
	}
	public void setProvinceEnglishName(String provinceEnglishName) {
		this.provinceEnglishName = provinceEnglishName;
	}
	public int getCurrentConfirmedCount() {
		return currentConfirmedCount;
	}
	public void setCurrentConfirmedCount(int currentConfirmedCount) {
		this.currentConfirmedCount = currentConfirmedCount;
	}
	public int getConfirmedCount() {
		return confirmedCount;
	}
	public void setConfirmedCount(int confirmedCount) {
		this.confirmedCount = confirmedCount;
	}
	public int getCuredCount() {
		return curedCount;
	}
	public void setCuredCount(int curedCount) {
		this.curedCount = curedCount;
	}
	public long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
	public String getCountryEnglishName() {
		return countryEnglishName;
	}
	public void setCountryEnglishName(String countryEnglishName) {
		this.countryEnglishName = countryEnglishName;
	}

}
