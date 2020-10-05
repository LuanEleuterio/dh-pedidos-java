package br.com.dh.desafiovespertino.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.desafiovespertino.model.entity.Pedido;
import br.com.dh.desafiovespertino.model.repositories.PedidoRepository;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	
	@GetMapping()
	public Iterable<Pedido> getPedidos(){
		return pedidoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Pedido> getPedido(@PathVariable Integer id){
		return pedidoRepository.findById(id);
	}
	
	@PostMapping()
	public void addPedido(@RequestBody Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	@DeleteMapping("/{id}")
	public void deletePedido(@PathVariable Integer id) {
		pedidoRepository.deleteById(id);
	}
	
	@PutMapping("/{idPedido}")
	public Pedido updatePedido(@PathVariable Integer idPedido, @RequestBody Pedido dadosPedido) throws Exception{
		Pedido pedidoDB = pedidoRepository.findById(idPedido)
				.orElseThrow(() -> new IllegalAccessException());
		
		if(dadosPedido.getNfe() != null) pedidoDB.setNfe(dadosPedido.getNfe());
		if(dadosPedido.getStatus_pedido() != null) pedidoDB.setStatus_pedido(dadosPedido.getStatus_pedido());
		if(dadosPedido.getQuantidade() != null) pedidoDB.setQuantidade(dadosPedido.getQuantidade());
		//if(dadosPedido.getFk_id_cliente() != null) pedidoDB.setFk_id_cliente(dadosPedido.getFk_id_cliente());
		//if(dadosPedido.getFk_id_funcionario() != null) pedidoDB.setFk_id_funcionario(dadosPedido.getFk_id_funcionario());
		return pedidoRepository.save(pedidoDB);
	}
}
