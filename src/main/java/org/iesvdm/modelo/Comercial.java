package org.iesvdm.modelo;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comercial {

	public Comercial() {
	
	}
	
	private int id;
	
	@NotBlank(message = "{error.nombre}")
	@Size(max=30, message = "{error.size.max.nombre")
	private String nombre;
	
	@NotBlank(message = "{error.apellido}")
	@Size(max=30, message = "{error.size.max.apellido}")
	private String apellido1;
	
	
	private String apellido2;
	@NotNull(message = "{error.comision.nulo}")
	@DecimalMin(value="0.276", message = "{error.size.min.comision}")
	@DecimalMax(value="0.946", message = "{error.size.max.comision}")
	private BigDecimal comision;
	
}
