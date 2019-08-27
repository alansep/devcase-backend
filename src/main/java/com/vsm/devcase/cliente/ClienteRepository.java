package com.vsm.devcase.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de persitência referente aos Clientes da aplicação.
 * @author Gabriel Alan
 *
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
