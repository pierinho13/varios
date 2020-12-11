package com.meep.Prueba.infrastructure.valueobjects;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ParamsVehiculoDto implements Serializable {

	private String zona;
	private Double lowerLeftLat; 
	private Double lowerLeftLon; 
	private Double upperRightLat; 
	private Double upperRightLon; 
	private Set<Long> companyZoneIds = new HashSet<>();
	
	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public Double getLowerLeftLat() {
		return lowerLeftLat;
	}

	public void setLowerLeftLat(Double lowerLeftLat) {
		this.lowerLeftLat = lowerLeftLat;
	}

	public Double getLowerLeftLon() {
		return lowerLeftLon;
	}

	public void setLowerLeftLon(Double lowerLeftLon) {
		this.lowerLeftLon = lowerLeftLon;
	}

	public Double getUpperRightLat() {
		return upperRightLat;
	}

	public void setUpperRightLat(Double upperRightLat) {
		this.upperRightLat = upperRightLat;
	}

	public Double getUpperRightLon() {
		return upperRightLon;
	}

	public void setUpperRightLon(Double upperRightLon) {
		this.upperRightLon = upperRightLon;
	}

	public Set<Long> getCompanyZoneIds() {
		return companyZoneIds;
	}

	public void setCompanyZoneIds(Set<Long> companyZoneIds) {
		this.companyZoneIds = companyZoneIds;
	}
	
	private static final long serialVersionUID = -1603042678952042198L;

}
