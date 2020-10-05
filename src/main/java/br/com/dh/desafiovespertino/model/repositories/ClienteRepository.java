package br.com.dh.desafiovespertino.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.desafiovespertino.model.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

}
