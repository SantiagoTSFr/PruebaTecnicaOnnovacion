package com.pruebaSanti.controller;

import com.pruebaSanti.model.ClientePersonaJuridica;
import com.pruebaSanti.model.ClientePersonaNatural;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pruebaSanti.service.PersonaNaturalService;

import java.util.List;

@RestController
@RequestMapping("/apiPerNat")
@CrossOrigin("*")
public class PersonaNaturalController {
    @Autowired
    private PersonaNaturalService personaNaturalService;

    @GetMapping("/all")
    public List<ClientePersonaNatural> getAll() {
        return personaNaturalService.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public ClientePersonaNatural find(@PathVariable Long id) {
        return personaNaturalService.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ClientePersonaNatural> save(@RequestBody ClientePersonaNatural persona) {
        List<ClientePersonaNatural> clientes = personaNaturalService.getAll();
        boolean test = true;
        for(int i=0; clientes.size()>i;i++){
            if(persona.getRut().equals(clientes.get(i).getRut())) {
                test=false;
            }
        }
        if(test){
            ClientePersonaNatural obj = personaNaturalService.save(persona);
            return new ResponseEntity<ClientePersonaNatural>(obj, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<ClientePersonaNatural> delete(@PathVariable Long id) {
        ClientePersonaNatural persona = personaNaturalService.get(id);
        if (persona != null) {
            personaNaturalService.delete(id);
        } else {
            return new ResponseEntity<ClientePersonaNatural>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<ClientePersonaNatural>(persona, HttpStatus.OK);
    }
}