package org.iesvdm.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.iesvdm.dto.PedidoDTO;
import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

//Anotación lombok para logging (traza) de la aplicación
@Slf4j
//Un Repository es un componente y a su vez un estereotipo de Spring 
//que forma parte de la ‘capa de persistencia’.
@Repository
public class PedidoDAOImpl implements PedidoDAO {

	 //Plantilla jdbc inyectada automáticamente por el framework Spring, gracias a la anotación @Autowired.
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	
	/**
	 * Inserta en base de datos el nuevo Cliente, actualizando el id en el bean Cliente.
	 */

	@Override
	public List<PedidoDTO> getAll(int idComercial) {
		
		List<PedidoDTO> listPed = jdbcTemplate.query(
                "SELECT P.*, C.nombre as nombre_cliente FROM pedido P inner join cliente C ON P.id_cliente = C.id WHERE P.id_comercial=?",
                (rs, rowNum) -> new PedidoDTO(rs.getInt("id"),
                						 	rs.getDouble("total"),
                						 	rs.getString("fecha"),
                						 	rs.getString("id_cliente"),
                						 	rs.getString("id_comercial"),
                						 	rs.getString("nombre_cliente")
        ),idComercial);
		
		log.info("Devueltos {} registros.", listPed.size());
		
        return listPed;
        
	}
	
}