package com.meep.Prueba.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.meep.Prueba.infrastructure.model.Vehiculo;
import com.meep.Prueba.infrastructure.valueobjects.ResultadoCambiosVehiculosDto;

public class CambiosVehiculosServiceTest {

	
	@Test
	public void testGetInformacionCambiosVehiculosSinCambios() throws Exception {
		
		Set<String> vehiculosDisponiblesAnterioresId = new HashSet<>();
		
		vehiculosDisponiblesAnterioresId.add("AA");
		vehiculosDisponiblesAnterioresId.add("BB");
		
		CambiosVehiculosService cambiosVehiculosService =  new CambiosVehiculosService();
		
		ReflectionTestUtils.setField(cambiosVehiculosService, "vehiculosDisponiblesAnterioresId", vehiculosDisponiblesAnterioresId);
		
		List<Vehiculo> vehiculosEntrantes = new ArrayList<>();
		
		Vehiculo vehiculoA = new Vehiculo();
		vehiculoA.setId("AA");
		
		Vehiculo vehiculoB = new Vehiculo();
		vehiculoB.setId("BB");
		
		vehiculosEntrantes.add(vehiculoA);
		vehiculosEntrantes.add(vehiculoB);
		
		
		ResultadoCambiosVehiculosDto resultadoCambiosVehiculosDto =  cambiosVehiculosService.getInformacionCambiosVehiculos(vehiculosEntrantes);
		
		assertNotNull(resultadoCambiosVehiculosDto);
		assertFalse(resultadoCambiosVehiculosDto.getCambios());
		
	}
	
	@Test
	public void testGetInformacionCambiosVehiculosConVehiculosNuevos() throws Exception {
		
		Set<String> vehiculosDisponiblesAnterioresId = new HashSet<>();
		
		vehiculosDisponiblesAnterioresId.add("AA");
		vehiculosDisponiblesAnterioresId.add("BB");
		
		
		CambiosVehiculosService cambiosVehiculosService =  new CambiosVehiculosService();
		
		ReflectionTestUtils.setField(cambiosVehiculosService, "vehiculosDisponiblesAnterioresId", vehiculosDisponiblesAnterioresId);
		
		List<Vehiculo> vehiculosEntrantes = new ArrayList<>();
		
		Vehiculo vehiculoA = new Vehiculo();
		vehiculoA.setId("AA");
		
		Vehiculo vehiculoB = new Vehiculo();
		vehiculoB.setId("BB");
		
		Vehiculo vehiculoC = new Vehiculo();
		vehiculoC.setId("CC");
		
		vehiculosEntrantes.add(vehiculoA);
		vehiculosEntrantes.add(vehiculoB);
		vehiculosEntrantes.add(vehiculoC);
		
		
		ResultadoCambiosVehiculosDto resultadoCambiosVehiculosDto =  cambiosVehiculosService.getInformacionCambiosVehiculos(vehiculosEntrantes);
		
		assertNotNull(resultadoCambiosVehiculosDto);
		assertTrue(resultadoCambiosVehiculosDto.getCambios());
		assertEquals(1, resultadoCambiosVehiculosDto.getVehiculosNuevosIds().size());
	}
	
	@Test
	public void testGetInformacionCambiosVehiculosConVehiculosRetirados() throws Exception {
		
		Set<String> vehiculosDisponiblesAnterioresId = new HashSet<>();
		
		vehiculosDisponiblesAnterioresId.add("AA");
		vehiculosDisponiblesAnterioresId.add("BB");
		vehiculosDisponiblesAnterioresId.add("CC");
		vehiculosDisponiblesAnterioresId.add("DD");
		vehiculosDisponiblesAnterioresId.add("EE");
		vehiculosDisponiblesAnterioresId.add("FF");
		
		
		CambiosVehiculosService cambiosVehiculosService =  new CambiosVehiculosService();
		
		ReflectionTestUtils.setField(cambiosVehiculosService, "vehiculosDisponiblesAnterioresId", vehiculosDisponiblesAnterioresId);
		
		List<Vehiculo> vehiculosEntrantes = new ArrayList<>();
		
		Vehiculo vehiculoA = new Vehiculo();
		vehiculoA.setId("AA");
		
		Vehiculo vehiculoB = new Vehiculo();
		vehiculoB.setId("BB");
		
		Vehiculo vehiculoC = new Vehiculo();
		vehiculoC.setId("CC");
		
		vehiculosEntrantes.add(vehiculoA);
		vehiculosEntrantes.add(vehiculoB);
		vehiculosEntrantes.add(vehiculoC);
		
		
		ResultadoCambiosVehiculosDto resultadoCambiosVehiculosDto =  cambiosVehiculosService.getInformacionCambiosVehiculos(vehiculosEntrantes);
		
		assertNotNull(resultadoCambiosVehiculosDto);
		assertTrue(resultadoCambiosVehiculosDto.getCambios());
		assertEquals(3, resultadoCambiosVehiculosDto.getVehiculosRetiradosIds().size());
		
	}
	
}
