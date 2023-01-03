package org.iesvdm.dao;

import java.util.List;

import org.iesvdm.dto.PedidoDTO;
import org.iesvdm.modelo.Cliente;

public interface PedidoDAO {

	public List<PedidoDTO> getAll(int idComercial);

	List<Cliente> getClienteOrd(int idComercial);
		
}
