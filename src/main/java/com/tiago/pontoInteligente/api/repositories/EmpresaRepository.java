package com.tiago.pontoInteligente.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tiago.pontoInteligente.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	 // Notacao para sinalizar que todos os metodos seroa apenas de leitura, isso ajuda na performance
	@Transactional(readOnly = true)
	Empresa findByCnpj(String cnpj);

}
