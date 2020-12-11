package com.meep.Prueba.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.meep.Prueba.infrastructure.model.Vehiculo;
import com.meep.Prueba.infrastructure.valueobjects.ResultadoCambiosVehiculosDto;

@Service
public class CambiosVehiculosService {
	
	private Set<String> vehiculosDisponiblesAnterioresId = new HashSet<>();
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public ResultadoCambiosVehiculosDto getInformacionCambiosVehiculos(List<Vehiculo> vehiculosEntrantes) {
		
		logger.debug("getInformacionCambiosVehiculos() Se va obtener informacion sobre cambios en disponibilidad en vehiculos");
		
		ResultadoCambiosVehiculosDto resultadoCambiosVehiculosDto = null;
		
		Set<String> vehiculosActualesIds =  vehiculosEntrantes.stream().map(v-> v.getId()).collect(Collectors.toSet());
		
		List<String> coincidencias = new ArrayList<>((CollectionUtils.intersection(vehiculosActualesIds, vehiculosDisponiblesAnterioresId)));

		logger.debug("Numero de vehiculos entrantes = {} numero anteriores = {} numero coincidencias es {} ", vehiculosActualesIds.size(), vehiculosDisponiblesAnterioresId.size(), coincidencias.size());
		
		boolean mismoTamano = vehiculosActualesIds.size() == vehiculosDisponiblesAnterioresId.size();
		
		boolean cambios = !mismoTamano || vehiculosActualesIds.size() != coincidencias.size();
		
		logger.debug("Cambios en los vehiculos = {} ", cambios);
		
		if(cambios) {
			resultadoCambiosVehiculosDto = this.getCambiosEntreListadosVehiculosIds(vehiculosActualesIds, this.vehiculosDisponiblesAnterioresId);
		} else {
			resultadoCambiosVehiculosDto = ResultadoCambiosVehiculosDto.builder()
					.cambios(Boolean.FALSE)
					.build();
		}
		
		this.vehiculosDisponiblesAnterioresId = new HashSet<>(vehiculosActualesIds);
		
		return resultadoCambiosVehiculosDto;
		
	}
	
	private ResultadoCambiosVehiculosDto getCambiosEntreListadosVehiculosIds(Set<String> vehiculosActualesIds, Set<String> vehiculosDisponiblesAnterioresId) {
		
		Set<String> vehiculosNuevosIds = this.getVehiculosNuevosIds(vehiculosActualesIds, vehiculosDisponiblesAnterioresId);
		Set<String> vehiculosRetiradosIds = this.getVehiculosRetiradosIds(vehiculosActualesIds, vehiculosDisponiblesAnterioresId);
		
		ResultadoCambiosVehiculosDto resultadoCambiosVehiculosDto = ResultadoCambiosVehiculosDto.builder()
				.vehiculosNuevosIds(vehiculosNuevosIds)
				.vehiculosRetiradosIds(vehiculosRetiradosIds)
				.cambios(Boolean.TRUE)
				.build();
		
		return resultadoCambiosVehiculosDto;
	}
	
	
	private Set<String> getVehiculosNuevosIds(Set<String> vehiculosActualesIds, Set<String> vehiculosDisponiblesAnterioresId) {
		
		logger.debug("getVehiculosNuevosIds()");
		
		Set<String> vehiculosNuevosIds = new HashSet<>();
		
		for(String vehiculoActual: vehiculosActualesIds) {
			
			if(!vehiculosDisponiblesAnterioresId.contains(vehiculoActual)) {
				vehiculosNuevosIds.add(vehiculoActual);
				logger.debug("Se ha detectado un vehiculo nuevo con ID = {} ", vehiculoActual);
			}
		}
		
	
		return vehiculosNuevosIds;
	}
	
	private Set<String> getVehiculosRetiradosIds(Set<String> vehiculosActualesIds, Set<String> vehiculosDisponiblesAnterioresId) {
		
		logger.debug("getVehiculosRetiradosIds()");
		
		Set<String> vehiculosRetiradosIds = new HashSet<>();
		
		for(String vehiculoAnterior: vehiculosDisponiblesAnterioresId) {
			
			if(!vehiculosActualesIds.contains(vehiculoAnterior)) {
				vehiculosRetiradosIds.add(vehiculoAnterior);
				logger.debug("Se ha detectado un vehiculo retirado con ID = {} ", vehiculoAnterior);
			}
		}
		
		
		return vehiculosRetiradosIds;
	}
	
}
