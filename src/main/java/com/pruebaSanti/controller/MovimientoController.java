package com.pruebaSanti.controller;

import com.pruebaSanti.model.ClientePersonaJuridica;
import com.pruebaSanti.model.Cuenta;
import com.pruebaSanti.model.Movimiento;
import com.pruebaSanti.service.CuentaService;
import com.pruebaSanti.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiMovimientos")
@CrossOrigin("*")
public class MovimientoController {
    @Autowired
    MovimientoService movimientoService;
    CuentaService cuentaService;
    @GetMapping("/all")
    public List<Movimiento> getAll(){return movimientoService.getAll();}
    @GetMapping(value = "/find/{id}")
    public Movimiento find(@PathVariable Long id) {
        return movimientoService.get(id);
    }
    @PostMapping(value = "/save")
    public ResponseEntity<Movimiento> save(@RequestBody Movimiento movimiento) {
        List<Cuenta> cuentas = cuentaService.getAll();

        for(int i =0; cuentas.size()>i;i++){
            if(movimiento.getIdCuenta().equals(cuentas.get(i).getNumeroCuenta())){
                if(validarMovimiento(movimiento)){
                    Movimiento obj = movimientoService.save(movimiento);
                    cuentas.get(i).setSaldo(cuentas.get(i).getSaldo() + movimiento.getValor());
                }
            }else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public boolean validarMovimiento(Movimiento movimiento){
        boolean validar = false;
        if(movimiento.getMoneda() == "COP" && movimiento.getValor()<1000000){
            validar = true;
        }else if(movimiento.getMoneda() == "USD" && movimiento.getValor()<300){
            validar = true;
        }else if(movimiento.getMoneda() == "EUR" && movimiento.getValor()<150){
            validar = true;
        }else{
            validar= false;
        }
        return validar;

    }

}
