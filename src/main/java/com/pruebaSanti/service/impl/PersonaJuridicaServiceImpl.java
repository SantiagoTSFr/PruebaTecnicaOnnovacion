package com.pruebaSanti.service.impl;

import com.pruebaSanti.commons.GenericServiceImpl;
import com.pruebaSanti.model.ClientePersonaJuridica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.pruebaSanti.repository.PersonaJuridicaDaoAPI;
import com.pruebaSanti.service.PersonaJuridicaService;

@Component
public class PersonaJuridicaServiceImpl extends GenericServiceImpl<ClientePersonaJuridica,Long> implements PersonaJuridicaService {
    @Autowired
    PersonaJuridicaDaoAPI personaJuridicaDaoAPI;
    @Override
    public CrudRepository<ClientePersonaJuridica, Long> getDao() {
        return personaJuridicaDaoAPI;
    }
}
