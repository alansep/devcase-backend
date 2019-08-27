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
	@Query(value = "SELECT * FROM REGRA ORDER BY REG_VALOR_MAX DESC", nativeQuery = true)
	public List<Regra> findAllOrderByMaximoDesc();

}
