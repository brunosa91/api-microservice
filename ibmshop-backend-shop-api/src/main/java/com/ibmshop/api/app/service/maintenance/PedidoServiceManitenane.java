package com.ibmshop.api.app.service.maintenance;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ibmshop.api.app.dto.input.DetalhePedidoDtoInserir;
import com.ibmshop.api.app.dto.input.PedidoDtoInserir;
import com.ibmshop.api.app.dto.output.PedidoDtoListar;
import com.ibmshop.api.app.dto.output.product.ProductDtoOutput;
import com.ibmshop.api.app.feignclients.ProductClient;
import com.ibmshop.api.app.feignclients.UserClient;
import com.ibmshop.api.app.mapper.PedidosMapperImpl;
import com.ibmshop.api.domain.entity.DetalhePedido;
import com.ibmshop.api.domain.entity.Pedido;
import com.ibmshop.api.domain.entity.Status;
import com.ibmshop.api.domain.repository.PedidoRepository;

import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Component
public class PedidoServiceManitenane {
	
    private static final Logger logger = LogManager.getLogger(PedidoServiceManitenane.class);
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	UserClient userClient;
	
	@Autowired
	ProductClient productClient;
	
	@Autowired
	PedidosMapperImpl pedidoMapper;
	
	
	
	public void UserExist (Long userId) {
		if(userClient.findById(userId) == null) {
			throw new RuntimeException("Usuário não existe");
			
		}
	}
	private ProductDtoOutput findProduct(Long idProduct) {
        return Objects.requireNonNull(productClient.findById(idProduct).getBody());
    }

	
	public Pedido insert(PedidoDtoInserir pedidoDto) {
	    UserExist(pedidoDto.getUserId());

	    List<DetalhePedidoDtoInserir> detalhePedidoDtoInserirList = pedidoDto.getDetalhesPedido();
	    
        BigDecimal totalPedido = BigDecimal.ZERO;

		 
		 

		 
	   for (DetalhePedidoDtoInserir detalhePedidoDto : detalhePedidoDtoInserirList ) {
	        //detalhePedidoDto.setPedido(pedidoDto);
	        ProductDtoOutput productDtoOutput = findProduct(detalhePedidoDto.getIdProduct());
	        BigDecimal quantidade = new BigDecimal(detalhePedidoDto.getQuantidade());
	        BigDecimal sub_total = productDtoOutput.getValor_unitario().multiply(quantidade);
	        detalhePedidoDto.setSub_total(sub_total);
	        
	        
	        totalPedido = totalPedido.add(sub_total);
	       
	        
	    }
	    
	    
		pedidoDto.setData_criacao(LocalDateTime.now());
		
        pedidoDto.setTotal(totalPedido);
        
      


	    Pedido pedido = pedidoMapper.DtoToEntityPedido(pedidoDto);
	    
	    // esse detalher pedido vinculado setado um pedido
	    pedido.getDetalhesPedido().forEach(dp -> dp.setPedido(pedido));

	    return pedidoRepository.save(pedido); 	
	}

	

}
