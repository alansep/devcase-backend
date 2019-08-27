package com.vsm.devcase.venda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de persistência referente às Vendas da aplicação
 * 
 * @author alansep
 *
 */
@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

	/**
	 * Método que tem como função encontrar as Vendas que possuam data inicial maior
	 * ou igual à data informada, e data final menor ou igual à data também
	 * informada!
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @return List<Venda>
	 */
	public List<Venda> findAllByDataGreaterThanEqualAndDataLessThanEqual(String dataInicial, String dataFinal);
}
