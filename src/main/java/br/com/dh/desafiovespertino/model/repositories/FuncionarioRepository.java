package br.com.dh.desafiovespertino.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.desafiovespertino.model.entity.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer>{

}
