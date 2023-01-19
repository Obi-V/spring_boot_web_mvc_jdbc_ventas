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
	
	private int id;
	private float total;
	private String fecha;
	private int id_cliente;
	private int id_comercial;
	
	private String nombreCliente;
}