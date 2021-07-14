package com.pruebaSanti.repository;

import com.pruebaSanti.model.ClientePersonaJuridica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaJuridicaDaoAPI extends CrudRepository<ClientePersonaJuridica,Long> {

}
