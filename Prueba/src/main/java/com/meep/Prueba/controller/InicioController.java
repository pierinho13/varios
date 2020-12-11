package com.meep.Prueba.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.meep.Prueba.infrastructure.model.Vehiculo;
import com.meep.Prueba.infrastructure.valueobjects.ParamsVehiculoDto;
import com.meep.Prueba.service.RestService;
import com.meep.Prueba.service.VehiculoService;

@RestController
public class InicioController {
	
	@Autowired
	private RestService restService;
	@Autowired
	private VehiculoService vehiculoService;
	
	private static final String JSON_URL_TEST= "https://jsonplaceholder.typicode.com/todos/1";
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping({"/","/home","/inicio"})
	@ResponseBody String getPrincipal(HttpServletRequest request) {
		
		logger.debug("getPrincipal() solicitada desde IP " +request.getRemoteAddr());
		return "Pagina principal de la apliacion  prueba solicitada desde IP " +request.getRemoteAddr();
	}
	
	@RequestMapping("obtiene-json-prueba")
	@ResponseBody String getLlamaJsonPrueba(HttpServletRequest request) {
		
		logger.debug("getLlamaJsonPrueba() solicitada desde IP " +request.getRemoteAddr());
		
		String jsonPrueba = (String) this.restService.get(JSON_URL_TEST, null, String.class);
		
		logger.debug("El json de prueba es {} ", jsonPrueba);
		
		return "El json de prueba es " +jsonPrueba;
	}
	
	@RequestMapping("obtiene-json-llamada-directa")
	@ResponseBody String getLlamadaDirecta(HttpServletRequest request) {
		
		logger.debug("getLlamadaDirecta() solicitada desde IP " +request.getRemoteAddr());
		
		
		ParamsVehiculoDto paramsVehiculoDto = new ParamsVehiculoDto();
		
		paramsVehiculoDto.setZona("lisboa");
		paramsVehiculoDto.setLowerLeftLat(38.711046);
		paramsVehiculoDto.setLowerLeftLon(-9.160096);
		paramsVehiculoDto.setUpperRightLat(38.739429);
		paramsVehiculoDto.setUpperRightLon(-9.137115);
		
		Set<Long> companyZoneIds = new HashSet<>();
		companyZoneIds.add(545L);
		companyZoneIds.add(467L);
		companyZoneIds.add(473L);
		
		paramsVehiculoDto.setCompanyZoneIds(companyZoneIds);
		
		List<Vehiculo>  vehiculos = this.vehiculoService.getVehiculos(paramsVehiculoDto);
		
		Gson gson = new Gson();
		
		return "El json es " + gson.toJson(vehiculos) ;
	}
		
}
