package com.ibmshop.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibmshop.api.domain.entity.Pedido;
import com.ibmshop.api.domain.entity.Status;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
 
	Optional<Pedido>  findByStatusPedido(Status pedStatus);
  

}
