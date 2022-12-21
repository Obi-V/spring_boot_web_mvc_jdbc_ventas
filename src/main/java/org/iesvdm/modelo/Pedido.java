package org.iesvdm.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
//La anotación @Data de lombok proporcionará el código de: 
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans
@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
public class Pedido {
	
	public Pedido() {
		
	}
	
	public Pedido(int int1, double double1, String string, String string2, String string3) {
		
	}

	private int id;
	private double total;
	private String fecha;
	private int id_cliente;
	private int id_comercial;

}
