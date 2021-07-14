package com.pruebaSanti.service.impl;

import com.pruebaSanti.commons.GenericServiceImpl;
import com.pruebaSanti.model.Cuenta;
import com.pruebaSanti.service.CuentaService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.pruebaSanti.repository.CuentaDaoAPI;

@Component
public class CuentaServiceImpl extends GenericServiceImpl<Cuenta, Long> implements CuentaService {

    private CuentaDaoAPI cuentaDaoAPI;
    @Override
    public CrudRepository<Cuenta, Long> getDao() {
        return cuentaDaoAPI;
    }
}
