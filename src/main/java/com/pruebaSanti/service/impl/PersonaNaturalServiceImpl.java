package com.pruebaSanti.service.impl;

import com.pruebaSanti.commons.GenericServiceImpl;
import com.pruebaSanti.model.ClientePersonaNatural;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.pruebaSanti.repository.PersonaNaturalDaoAPI;
import com.pruebaSanti.service.PersonaNaturalService;
@Component
public class PersonaNaturalServiceImpl extends GenericServiceImpl<ClientePersonaNatural,Long> implements PersonaNaturalService {
    @Autowired
    PersonaNaturalDaoAPI personaNaturalDaoAPI;

    @Override
    public CrudRepository<ClientePersonaNatural, Long> getDao() {
        return personaNaturalDaoAPI;
    }
}
