package com.pruebaSanti.repository;

import com.pruebaSanti.model.Cuenta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaDaoAPI extends CrudRepository<Cuenta,Long> {
}
