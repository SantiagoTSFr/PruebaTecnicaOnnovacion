package com.pruebaSanti.repository;

import com.pruebaSanti.model.ClientePersonaNatural;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaNaturalDaoAPI extends CrudRepository<ClientePersonaNatural,Long> {

}
