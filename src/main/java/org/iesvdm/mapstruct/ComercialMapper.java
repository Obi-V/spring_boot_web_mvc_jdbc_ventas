package org.iesvdm.mapstruct;

import org.iesvdm.dto.*;
import org.iesvdm.modelo.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface ComercialMapper{
	
	@Mapping(target ="numPedTotal",source="numPedTotalIn")
	@Mapping(target ="numPedidoTrimestre",source="numPedidoTrimestreIn")
	@Mapping(target ="numPedidoSemestre",source="numPedidoSemestreIn")
	@Mapping(target ="numPedidoAnio",source="numPedidoAnioIn")
	@Mapping(target ="numPedidoLustro",source="numPedidoLustroIn")
	public ComercialDTO comercialAComercialDTO(Comercial comercial,int numPedTotalIn, int numPedidoTrimestreIn, int numPedidoSemestreIn, int numPedidoAnioIn, int numPedidoLustroIn);
	
	public Comercial comercialDTOAcomercial(ComercialDTO comercial);

}