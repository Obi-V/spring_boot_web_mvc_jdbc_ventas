package org.iesvdm.service;

import java.util.List;
import java.util.Optional;
import org.iesvdm.dao.ComercialDAO;
import org.iesvdm.dao.PedidoDAO;
import org.iesvdm.dto.ComercialDTO;
import org.iesvdm.dto.PedidoDTO;
import org.iesvdm.modelo.Cliente;
//import org.iesvdm.mapstruct.ComercialMapper;
import org.iesvdm.modelo.Comercial;
import org.iesvdm.modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComercialService {

	private ComercialDAO comercialDAO;
	private ComercialDTO comercialDTO;
	// private ComercialMapper comercialMapper;

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
			/*
			 * ComercialDTO comercialDTO = comercialMapper.comercialAComercialDTO(null, 0,
			 * 0, null, null);
			 */
			ComercialDTO comercialDTO = new ComercialDTO(c);

			List <Cliente> clientes = pedidoDAO.getClienteOrd(comercialDTO.getId());
			List<PedidoDTO> pedidos = pedidoDAO.getAll(comercialDTO.getId());

			float total = 0;
			float media = 0;
			float min = 0;
			float max = 0;
			
			if(pedidos.size() != 0) {
			
				min = pedidos.get(0).getTotal();
				max = pedidos.get(0).getTotal();
				
				for (var pedido : pedidos) {
	
					if (pedido.getTotal() > max) {
						max = pedido.getTotal();
					}
				}
				
				for (var pedido : pedidos) {
					if(pedido.getTotal()< min) {
						min = pedido.getTotal();
					}
				}
				for (var pedido : pedidos) {
					total += pedido.getTotal();
				}

			media = total / pedidos.size();

			comercialDTO.setPedidos(pedidos);
			comercialDTO.setClientes(clientes);
			comercialDTO.setTotalPed(total);
			comercialDTO.setMediaPed(media);
			comercialDTO.setPedidomax(max);
			comercialDTO.setPedidomin(min);
			}
			
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
