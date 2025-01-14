package org.iesvdm.service;

import java.util.List;
import java.util.Optional;

import org.iesvdm.dao.ClienteDAO;
import org.iesvdm.dao.PedidoDAO;
import org.iesvdm.dto.PedidoDTO;
import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.Comercial;
import org.iesvdm.modelo.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	
	private PedidoDAO pedidoDAO;
	
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public PedidoService(PedidoDAO pedidoDAO) {
		this.pedidoDAO = pedidoDAO;
	}
	
	public List<PedidoDTO> listAll(int idComercial) {
		
		return pedidoDAO.getAll(idComercial);
	
	}
	
}
