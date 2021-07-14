package com.pruebaSanti.service;

import com.pruebaSanti.commons.GenericServiceAPI;
import com.pruebaSanti.model.ClientePersonaNatural;
import org.springframework.stereotype.Service;

@Service
public interface PersonaNaturalService extends GenericServiceAPI<ClientePersonaNatural,Long> {
}
