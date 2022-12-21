package org.iesvdm.dto;

import org.iesvdm.modelo.Pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
//La anotación @Data de lombok proporcionará el código de: 
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans
@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
public class PedidoDTO {
	
	public PedidoDTO(int i, double d, String string, String string2, String string3, String string4) {
		
	}
	
	private Pedido pedido;
	private String nombreCliente;
}
