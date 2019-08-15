package com.thiagocaleb.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagocaleb.cursomc.domain.Categoria;
import com.thiagocaleb.cursomc.repositories.CategoriaRepository;
import com.thiagocaleb.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		Categoria cat = obj.orElse(null);
		if(cat==null) {
			throw new ObjectNotFoundException("Objeto nao encontrado! id: "+id+" ,Tipo: "+Categoria.class.getName());
		}
		return cat;
	}
}
