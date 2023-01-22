package org.iesvdm.mapstruct;

import java.util.List;

import org.iesvdm.dto.*;
import org.iesvdm.modelo.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface ComercialMapper{
	
	@Mapping(target ="mediaPed",source="mediaPed")
	@Mapping(target ="totalPed",source="totalPed")
	@Mapping(target ="pedidos",source="listPedidoDTO")
	@Mapping(target ="clientes",source="ListClientes")
	public ComercialDTO comercialAComercialDTO(Comercial comercial,float mediaPed, float totalPed, List<PedidoDTO> listPedidoDTO, List<Cliente> ListClientes, double pedidomax, double pedidomin);
	
	public Comercial comercialDTOAcomercial(ComercialDTO comercial);

}