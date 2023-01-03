package org.iesvdm.service;

import java.util.List;
import java.util.Optional;
import org.iesvdm.dao.ComercialDAO;
import org.iesvdm.dao.PedidoDAO;
import org.iesvdm.dto.ComercialDTO;
import org.iesvdm.modelo.Comercial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComercialService {

	private ComercialDAO comercialDAO;
	private ComercialDTO comercialDTO;

	// Se utiliza inyección automática por constructor del framework Spring.
	// Por tanto, se puede omitir la anotación Autowired
	// @Autowired
	public ComercialService(ComercialDAO comercialDAO) {
		this.comercialDAO = comercialDAO;
	}

	public List<Comercial> listAll() {
		return comercialDAO.getAll();

	}

	public Comercial one(Integer id) {
		Optional<Comercial> optCom = comercialDAO.find(id);
		if (optCom.isPresent())
			return optCom.get();
		else
			return null;
	}

	@Autowired
	private PedidoDAO pedidoDAO;

	public ComercialDTO oneDTO(Integer id) {
		Optional<Comercial> optCom = comercialDAO.find(id);
		if (optCom.isPresent()) {
			Comercial c = optCom.get();
			ComercialDTO comercialDTO = new ComercialDTO(c);
			
			var clientes = pedidoDAO.getClienteOrd(comercialDTO.getId());
			var pedidos = pedidoDAO.getAll(comercialDTO.getId());
			float total = 0;
			float media = 0;
			for(var pedido: pedidos) {
				total += pedido.getTotal();
			}
			media = total/pedidos.size();
			
			comercialDTO.setPedidos(pedidos);
			comercialDTO.setClientes(clientes);
			comercialDTO.setTotalPed(total);
			comercialDTO.setMediaPed(media);
			
			return comercialDTO;
		} else {
			return null;
		}
	}

	public void newComercial(Comercial comercial) {

		comercialDAO.create(comercial);

	}

	public void replaceComercial(Comercial comercial) {

		comercialDAO.update(comercial);
	}

	public void deleteComercial(int id) {

		comercialDAO.delete(id);

	}
}
