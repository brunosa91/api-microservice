package com.ibmshop.api.app.service.consultation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ibmshop.api.app.mapper.PedidosMapperImpl;

import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibmshop.api.app.dto.input.DetalhePedidoDtoInserir;
import com.ibmshop.api.app.dto.input.PedidoDtoInserir;
import com.ibmshop.api.app.dto.output.DetalhePedidoDtoListar;
import com.ibmshop.api.app.dto.output.PedidoDtoListar;
import com.ibmshop.api.app.dto.output.product.ProductDtoOutput;
import com.ibmshop.api.app.feignclients.ProductClient;
import com.ibmshop.api.app.feignclients.UserClient;
import com.ibmshop.api.domain.entity.DetalhePedido;
import com.ibmshop.api.domain.entity.Pedido;
import com.ibmshop.api.domain.entity.Status;
import com.ibmshop.api.domain.repository.PedidoRepository;

@Component
@Service
public class PedidoServiceConsultation {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserClient userClient;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PedidosMapperImpl pedidoMapper;

	@Autowired
	private ProductClient productClient;

	private ProductDtoOutput findProduct(Long idProduct) {
		return Objects.requireNonNull(productClient.findById(idProduct).getBody());
	}

	public List<PedidoDtoListar> findAll() {

		List<Pedido> listpedido = pedidoRepository.findAll();

		List<PedidoDtoListar> pedidosDtoList = listpedido.stream().map(pedidoMapper::entityToDtoPedido)
				.collect(Collectors.toList());

		log.info("Tentando listar");

		for (int i = 0; i < listpedido.size(); i++) {
			Pedido pedido = listpedido.get(i);

			List<DetalhePedido> detalhePedidos = pedido.getDetalhesPedido();

			List<DetalhePedidoDtoListar> detalhePedidoDtoListar = pedidosDtoList.get(i).getDetalhesPedido();
// daqui pra baixo será o método pro setProduto
			setProduto(detalhePedidos, detalhePedidoDtoListar);

		}
		;

		return pedidosDtoList;
	}

	private void setProduto(List<DetalhePedido> detalhePedidos, List<DetalhePedidoDtoListar> detalhePedidoDtoListar) {
		for (int j = 0; j < detalhePedidos.size(); j++) {

			DetalhePedido detalhePedido = detalhePedidos.get(j);
			DetalhePedidoDtoListar detalhePedidoDto = detalhePedidoDtoListar.get(j);

			Long idProduct = detalhePedido.getIdProduct();

			ProductDtoOutput productDtoOutput = findProduct(idProduct);
			log.info("\nnome produto: " + productDtoOutput.getNome_produto());
			System.out.println("nome produto: " + productDtoOutput.getNome_produto());
			detalhePedidoDto.setProduct(productDtoOutput);

		}
	};

	public PedidoDtoListar findById(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		PedidoDtoListar pedidoDtoListar = pedidoMapper.entityToDtoPedido(pedido.get());
		setProduto(pedido.get().getDetalhesPedido(), pedidoDtoListar.getDetalhesPedido());
		return pedidoDtoListar;
	}

	public PedidoDtoListar findByStatus(Status statusPedido) {
		Optional<Pedido> pedido = pedidoRepository.findByStatusPedido(statusPedido);
		PedidoDtoListar pedidoDtoListar = pedidoMapper.entityToDtoPedido(pedido.get());
		setProduto(pedido.get().getDetalhesPedido(), pedidoDtoListar.getDetalhesPedido());
		return pedidoDtoListar;
	}

	public void AlterarPedido(PedidoDtoListar pedido) {

		if (!pedido.getStatusPedido().equals(Status.AGPAGAMENTO)) {
			throw new RuntimeException(
					"Esse pedido não pode ser cancelado pois o pagamento já foi efetuado ou o pedido já foi cancelado, sentimos muito.");
		}

		pedido.setStatusPedido(Status.CANCELADO);
	}

	public void cancelarPedido(PedidoDtoListar dtoListar) {
		PedidoDtoListar pedido = findById(dtoListar.getId());

		AlterarPedido(pedido);

		pedido.setData_modificacao(pedido.getData_modificacao());

		Pedido pedidoEntity = pedidoMapper.DtoToEntityUpdatePedido(pedido);

		pedidoRepository.save(pedidoEntity);
	}

}
