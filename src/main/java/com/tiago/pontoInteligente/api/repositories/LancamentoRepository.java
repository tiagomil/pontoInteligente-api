package com.tiago.pontoInteligente.api.repositories;

import java.util.List;


import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.tiago.pontoInteligente.api.entities.Lancamento;

@Transactional(readOnly = true)
@NamedQueries({
	//Nome da classe seguido pelo nome do metodo
	@NamedQuery(name = "LancamentoRepository.findByFuncionarioId",
			query = "SELECT lanc FROM Lancamento lanc WHERE lanc.funcionario.id = :funcionarioId")
})
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
	
	List<Lancamento> findByFuncionario(@Param("funcionarioId")Long funcionarioId);
	
	// Pageable para retornar o resultado paginado, mesmo retorno do metodo acima por aqui retorna paginado
	Page<Lancamento> findByFuncionario(@Param("funcionarioId")Long funcionarioId, Pageable pageable);

}
