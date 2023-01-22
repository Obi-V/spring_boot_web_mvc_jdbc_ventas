package org.iesvdm.modelo;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
	
	@Min(value=(long) 0.276, message = "{error.size.min.comision}")
	@Max(value=(long)0.946, message = "{error.size.max.comision}")
	private BigDecimal comision;
	
}
