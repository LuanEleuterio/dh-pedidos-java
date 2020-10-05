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

import br.com.dh.desafiovespertino.model.entity.Funcionario;
import br.com.dh.desafiovespertino.model.repositories.FuncionarioRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@GetMapping()
	public Iterable<Funcionario> getFuncionarios(){
		return funcionarioRepository.findAll();
	}
	
	@GetMapping("/{id")
	public Optional<Funcionario> getFuncionario(@PathVariable Integer id){
		return funcionarioRepository.findById(id);
	}
	
	@PostMapping()
	public void addFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}
	
	@DeleteMapping("/{id}")
	public void deleteFuncionario(@PathVariable Integer id) {
		funcionarioRepository.deleteById(id);
	}
	
	@PutMapping("/{idFuncionario")
	public Funcionario updateFuncionario(@PathVariable Integer idFuncionario, @RequestBody Funcionario dadosFuncionario) throws Exception{
		Funcionario funcionarioDB = funcionarioRepository.findById(idFuncionario)
				.orElseThrow(() -> new IllegalAccessException());
		
		if(dadosFuncionario.getNome() != null) funcionarioDB.setNome(dadosFuncionario.getNome());
		if(dadosFuncionario.getCpf() != null)funcionarioDB.setCpf(dadosFuncionario.getCpf());
		if(dadosFuncionario.getEmail()!= null)funcionarioDB.setEmail(dadosFuncionario.getEmail());
		if(dadosFuncionario.getNascimento()!= null)funcionarioDB.setNascimento(dadosFuncionario.getNascimento());
		if(dadosFuncionario.getDtAdmissao()!= null)funcionarioDB.setDtAdmissao(dadosFuncionario.getDtAdmissao());
		if(dadosFuncionario.getDdd()!= null) funcionarioDB.setNascimento(dadosFuncionario.getDdd());
		if(dadosFuncionario.getTelefone()!= null)funcionarioDB.setTelefone(dadosFuncionario.getTelefone());
		if(dadosFuncionario.getHabilitado()!= null)funcionarioDB.setHabilitado(dadosFuncionario.getHabilitado());
		if(dadosFuncionario.getSalario()!= null)funcionarioDB.setSalario(dadosFuncionario.getSalario());
		
		return funcionarioRepository.save(funcionarioDB);
	}
}
