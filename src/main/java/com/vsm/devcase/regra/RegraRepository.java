package com.vsm.devcase.regra;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface de Persistência dos dados referentes às regras do sistema.
 * @author Gabriel Alan
 */
@Repository
public interface RegraRepository extends JpaRepository<Regra, Integer> {

	/**
	 * Método customizado que retorna todas regras ordenadas pelo valor máximo de fomra descrescente. 
	 * @return List<Regra>
	 */
	@Query(value = "select * from regra order by reg_valor_max desc", nativeQuery = true)
	public List<Regra> findAllOrderByMaximoDesc();

}
