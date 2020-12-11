package com.meep.Prueba.infrastructure.valueobjects;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;

import org.junit.jupiter.api.Test;


public class ResultadoCambiosVehiculosDtoTest {

	@Test
	public void testBuilder() throws Exception {
		
		ResultadoCambiosVehiculosDto resultadoCambiosVehiculosDto = ResultadoCambiosVehiculosDto
				.builder()
				.vehiculosNuevosIds(new HashSet<>())
				.vehiculosRetiradosIds(new HashSet<>())
				.build();
		
		assertNotNull(resultadoCambiosVehiculosDto);
	}

}
