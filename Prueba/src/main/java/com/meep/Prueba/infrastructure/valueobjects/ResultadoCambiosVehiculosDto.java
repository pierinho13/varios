package com.meep.Prueba.infrastructure.valueobjects;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ResultadoCambiosVehiculosDto implements Serializable {
	
	private Set<String> vehiculosNuevosIds = new HashSet<>();
	private Set<String> vehiculosRetiradosIds = new HashSet<>();
	private Boolean cambios;
	
	public Set<String> getVehiculosNuevosIds() {
		return vehiculosNuevosIds;
	}

	public void setVehiculosNuevosIds(Set<String> vehiculosNuevosIds) {
		this.vehiculosNuevosIds = vehiculosNuevosIds;
	}

	public Set<String> getVehiculosRetiradosIds() {
		return vehiculosRetiradosIds;
	}

	public void setVehiculosRetiradosIds(Set<String> vehiculosRetiradosIds) {
		this.vehiculosRetiradosIds = vehiculosRetiradosIds;
	}
	
	public Boolean getCambios() {
		return cambios;
	}

	public void setCambios(Boolean cambios) {
		this.cambios = cambios;
	}

	private static final long serialVersionUID = 5150565944759472391L;

	private ResultadoCambiosVehiculosDto(Builder builder) {
		this.vehiculosNuevosIds = builder.vehiculosNuevosIds;
		this.vehiculosRetiradosIds = builder.vehiculosRetiradosIds;
		this.cambios = builder.cambios;
	}

	/**
	 * Creates builder to build {@link ResultadoCambiosVehiculosDto}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link ResultadoCambiosVehiculosDto}.
	 */
	public static final class Builder {
		private Set<String> vehiculosNuevosIds =  new HashSet<>();
		private Set<String> vehiculosRetiradosIds =  new HashSet<>();
		private Boolean cambios;

		private Builder() {
		}

		public Builder vehiculosNuevosIds(Set<String> vehiculosNuevosIds) {
			this.vehiculosNuevosIds = vehiculosNuevosIds;
			return this;
		}

		public Builder vehiculosRetiradosIds(Set<String> vehiculosRetiradosIds) {
			this.vehiculosRetiradosIds = vehiculosRetiradosIds;
			return this;
		}

		public Builder cambios(Boolean cambios) {
			this.cambios = cambios;
			return this;
		}

		public ResultadoCambiosVehiculosDto build() {
			return new ResultadoCambiosVehiculosDto(this);
		}
	}
	

}
