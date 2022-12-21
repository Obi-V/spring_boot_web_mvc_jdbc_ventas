package org.iesvdm.dto;

import java.util.List;

import org.iesvdm.modelo.Comercial;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComercialDTO {

	public ComercialDTO() {
	
	}
	
	private Comercial comercial;
	private List<PedidoDTO> pedidos;
	
}
