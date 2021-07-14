package com.pruebaSanti.controller;

import com.pruebaSanti.model.ClientePersonaJuridica;
import com.pruebaSanti.model.Cuenta;
import com.pruebaSanti.model.Movimiento;
import com.pruebaSanti.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiCuentas")
@CrossOrigin("*")
public class CuentaController {
    @Autowired
    CuentaService cuentaService;
    @GetMapping("/all")
    public List<Cuenta> getAll(){
        return cuentaService.getAll();
    }
    @GetMapping(value = "/find/{id}")
    public Cuenta find(@PathVariable Long id) {
        return cuentaService.get(id);
    }
    @PostMapping(value = "/save")
    public ResponseEntity<Cuenta> save(@RequestBody Cuenta cuenta) {
        if(!cuentaService.getAll().contains(cuenta)) {
            Cuenta obj = cuentaService.save(cuenta);
            return new ResponseEntity<Cuenta>(obj, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Cuenta> delete(@PathVariable Long id) {
        Cuenta cuenta = cuentaService.get(id);
        if (cuenta != null) {
            cuentaService.delete(id);
        } else {
            return new ResponseEntity<Cuenta>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Cuenta>(cuenta, HttpStatus.OK);
    }
}
