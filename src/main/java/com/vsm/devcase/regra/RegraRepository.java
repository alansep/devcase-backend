package com.vsm.devcase.regra;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegraRepository extends JpaRepository<Regra, Integer> {

	@Query(value = "SELECT * FROM REGRA ORDER BY REG_VALOR_MAX DESC", nativeQuery = true)
	public List<Regra> findAllOrderByMaximoDesc();

}
