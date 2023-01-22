package org.iesvdm.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.Comercial;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComercialDTO {

	public ComercialDTO() {
	
	}
	
	public ComercialDTO(Comercial comercial) {
		this.id = comercial.getId();
		this.nombre = comercial.getNombre();
		this.apellido1 = comercial.getApellido1();
		this.apellido2 = comercial.getApellido2();
		this.comision = comercial.getComision();
	}
	
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private BigDecimal comision;
	
	private float pedidomin;
	private float pedidomax;
	private float mediaPed;
	private float totalPed;
	private List<PedidoDTO> pedidos;
	private List<Cliente> clientes;

}
