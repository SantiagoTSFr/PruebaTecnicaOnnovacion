package com.pruebaSanti.repository;

import com.pruebaSanti.model.Movimiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoDaoAPI extends CrudRepository<Movimiento, Long> {
}
