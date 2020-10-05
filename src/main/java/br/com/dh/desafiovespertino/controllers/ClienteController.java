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

import br.com.dh.desafiovespertino.model.entity.Cliente;
import br.com.dh.desafiovespertino.model.repositories.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping()
	public Iterable<Cliente> getClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Cliente> getClienteById(@PathVariable Integer id) {
		return clienteRepository.findById(id);
	}
	
	@PostMapping()
	public void addCliente(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
	} 
	
	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable Integer id) {
		clienteRepository.deleteById(id);
	}
	
	@PutMapping("/{idCliente}")
	public Cliente updateCliente(@PathVariable Integer idCliente, @RequestBody Cliente dadosCliente) throws Exception{
		Cliente clienteDB = clienteRepository.findById(idCliente)
				.orElseThrow(() -> new IllegalAccessException());
		
		if(dadosCliente.getNome() != null) clienteDB.setNome(dadosCliente.getNome());
		if(dadosCliente.getCpf() != null)clienteDB.setCpf(dadosCliente.getCpf());
		if(dadosCliente.getEmail()!= null)clienteDB.setEmail(dadosCliente.getEmail());
		if(dadosCliente.getNascimento()!= null)clienteDB.setNascimento(dadosCliente.getNascimento());
		if(dadosCliente.getDdd()!= null) clienteDB.setNascimento(dadosCliente.getDdd());
		if(dadosCliente.getTelefone()!= null)clienteDB.setTelefone(dadosCliente.getTelefone());
		
		return clienteRepository.save(clienteDB);
	}
}
