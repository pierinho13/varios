package com.meep.Prueba.scheduler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.meep.Prueba.infrastructure.model.Vehiculo;
import com.meep.Prueba.infrastructure.valueobjects.ParamsVehiculoDto;
import com.meep.Prueba.infrastructure.valueobjects.ResultadoCambiosVehiculosDto;
import com.meep.Prueba.service.CambiosVehiculosService;
import com.meep.Prueba.service.VehiculoService;

@Service
public class TareaProgramadaService {

	@Autowired
	private VehiculoService vehiculoService;
	@Autowired
	private CambiosVehiculosService cambiosVehiculosService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Cada cada 30 segundos se lanza llamada
	 */
	@Scheduled(fixedRate=30000)
	public void getInformacionVehiculos() {
	
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
		
		List<Vehiculo> vehiculos = this.vehiculoService.getVehiculos(paramsVehiculoDto);
		
		ResultadoCambiosVehiculosDto resultadoCambiosVehiculosDto =  this.cambiosVehiculosService.getInformacionCambiosVehiculos(vehiculos);
		
		if(resultadoCambiosVehiculosDto != null) {
			logger.debug("Cambios en vehiculos =  {} ", resultadoCambiosVehiculosDto.getCambios());
			logger.debug("Vehiculos nuevos size {} y son {} ",resultadoCambiosVehiculosDto.getVehiculosNuevosIds().size(), resultadoCambiosVehiculosDto.getVehiculosNuevosIds());
			logger.debug("Vehiculos retirados size {} y son {} ", resultadoCambiosVehiculosDto.getVehiculosRetiradosIds().size(), resultadoCambiosVehiculosDto.getVehiculosRetiradosIds());
		}
		
		
	}
}
