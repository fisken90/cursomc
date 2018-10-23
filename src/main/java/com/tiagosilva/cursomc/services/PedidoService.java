package com.tiagosilva.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagosilva.cursomc.domain.Pedido;
import com.tiagosilva.cursomc.repositories.PedidoRepository;
import com.tiagosilva.cursomc.services.exceptions.ObjNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido get(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException(
				"Objeto não encontrado, ID: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
