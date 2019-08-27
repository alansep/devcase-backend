package com.vsm.devcase.venda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

	public List<Venda> findAllByDataGreaterThanEqualAndDataLessThanEqual(String dataInicial, String dataFinal);
}
