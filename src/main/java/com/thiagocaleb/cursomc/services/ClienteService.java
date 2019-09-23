package com.thiagocaleb.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagocaleb.cursomc.domain.Cliente;
import com.thiagocaleb.cursomc.repositories.ClienteRepository;
import com.thiagocaleb.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		Cliente cli = obj.orElse(null);
		if(cli==null) {
			throw new ObjectNotFoundException("Objeto nao encontrado! id: "+id+" ,Tipo: "+Cliente.class.getName());
		}
		return cli;
	}
}
