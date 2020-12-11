package com.meep.Prueba.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.meep.Prueba.infrastructure.model.Vehiculo;
import com.meep.Prueba.infrastructure.valueobjects.ParamsVehiculoDto;

@Service
public class VehiculoService {

	@Value("${url.prueba:}")
	private String urlPrueba;
	@Autowired
	private RestService restService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public List<Vehiculo> getVehiculos(ParamsVehiculoDto paramsVehiculoDto) {
		
		List<Vehiculo> vehiculos = new ArrayList<>();
		
		String urlConZona = this.getUrlConZona(paramsVehiculoDto);
		
		if(urlConZona == null) {
			throw new IllegalArgumentException("Url a donde llamar no puede ser null");
		}
		
		Map<String, Object> params = this.getParamsVehiculo(paramsVehiculoDto);
		

		ResponseEntity<List<Vehiculo>> responseEntity =  this.restService.exchange(urlConZona, HttpMethod.GET , new ParameterizedTypeReference<List<Vehiculo>>() {
        }, params);
		
		vehiculos = responseEntity.getBody();
		
		Gson gson = new Gson();
		
		logger.debug("Tamaño datos recibidos: {} ",vehiculos.size());
		logger.debug("Datos recibidos: {} ",gson.toJson(vehiculos));
		
		return vehiculos;
		
	}
	
	private String getUrlConZona(ParamsVehiculoDto paramsVehiculoDto) {
		
		String urlConZona = null;
		
		if(StringUtils.isNotBlank(urlPrueba) 
				&& paramsVehiculoDto != null 
				&& StringUtils.isNotBlank(paramsVehiculoDto.getZona())) {
			
			urlConZona = urlPrueba.replace("<ZONA_ID>", paramsVehiculoDto.getZona());
			
		}
		
		return urlConZona;
	}
	
	
	private Map<String, Object> getParamsVehiculo(ParamsVehiculoDto paramsVehiculoDto) {
		
		Map<String, Object> params = new HashMap<>();
		
		String lowerLeftLatLon = paramsVehiculoDto.getLowerLeftLat()+","+paramsVehiculoDto.getLowerLeftLon();
		params.put("lowerLeftLatLon", lowerLeftLatLon);
		
		String  upperRightLatLon = paramsVehiculoDto.getUpperRightLat()+","+paramsVehiculoDto.getUpperRightLon();
		params.put("upperRightLatLon", upperRightLatLon);
		
		String companyZoneIds = paramsVehiculoDto.getCompanyZoneIds().stream().map(c-> String.valueOf(c)).collect(Collectors.joining(","));
		params.put("companyZoneIds", companyZoneIds);
		
		return params;
	}
}
