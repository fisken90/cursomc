package com.tiagosilva.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagosilva.cursomc.domain.Cliente;
import com.tiagosilva.cursomc.repositories.ClienteRepository;
import com.tiagosilva.cursomc.services.exceptions.ObjNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException(
				"Objeto não encontrado, ID: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
