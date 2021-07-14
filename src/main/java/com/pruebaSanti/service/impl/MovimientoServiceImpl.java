package com.pruebaSanti.service.impl;

import com.pruebaSanti.commons.GenericServiceImpl;
import com.pruebaSanti.model.Movimiento;
import com.pruebaSanti.service.MovimientoService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.pruebaSanti.repository.MovimientoDaoAPI;

@Component
public class MovimientoServiceImpl extends GenericServiceImpl<Movimiento, Long> implements MovimientoService {

    private MovimientoDaoAPI movimientoDaoAPI;
    @Override
    public CrudRepository<Movimiento, Long> getDao() {
        return movimientoDaoAPI;
    }
}
