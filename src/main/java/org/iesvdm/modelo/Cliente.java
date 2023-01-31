package org.iesvdm.modelo;
import org.iesvdm.validador.RangoCategoria;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
//La anotación @Data de lombok proporcionará el código de: 
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans
@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
public class Cliente {
	
	public Cliente() {
		
	}
	
	private long id;
	
	@NotBlank(message = "{error.nombre}")
	@Size(max=30, message = "{error.size.max.nombre}")
	private String nombre;
	
	@NotBlank(message = "{error.apellido}")
	@Size(max=30, message = "{error.size.max.apellido}")
	private String apellido1;
	
	private String apellido2;
	
	@NotBlank(message = "{error.ciudad}")
	@Size(max=50, message = "{error.size.max.ciudad}")
	private String ciudad;
	
	@RangoCategoria
	@Min(value=100, message = "{error.size.min.categoria}")
	@Max(value=1000, message = "{error.size.max.categoria}")
	private int categoria;
	
	@Email(message = "{error.email.formato}")
	@NotBlank(message = "{error.email}")
	private String email;
	
	private double totalPedido;

}
