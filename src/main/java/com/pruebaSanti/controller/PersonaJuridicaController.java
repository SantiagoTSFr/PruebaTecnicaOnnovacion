package com.pruebaSanti.controller;

import com.pruebaSanti.model.ClientePersonaJuridica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pruebaSanti.service.PersonaJuridicaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apiPerJur")
@CrossOrigin("*")
public class PersonaJuridicaController {
    @Autowired
    PersonaJuridicaService personaJuridicaService;
    @GetMapping("/all")
    public List<ClientePersonaJuridica> getAll(){
        return personaJuridicaService.getAll();
    }
    @GetMapping(value = "/find/{id}")
    public ClientePersonaJuridica find(@PathVariable Long id) {
        return personaJuridicaService.get(id);
    }
    @PostMapping(value = "/save")
    public ResponseEntity<ClientePersonaJuridica> save(@RequestBody ClientePersonaJuridica persona) {
        List<ClientePersonaJuridica> clientes = personaJuridicaService.getAll();
        boolean test = true;
        for(int i=0; clientes.size()>i;i++){
            if(persona.getRut().equals(clientes.get(i).getRut())) {
                test=false;
            }
        }
        if(test){
            ClientePersonaJuridica obj = personaJuridicaService.save(persona);
            return new ResponseEntity<ClientePersonaJuridica>(obj, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<ClientePersonaJuridica> delete(@PathVariable Long id) {
        ClientePersonaJuridica persona = personaJuridicaService.get(id);
        if (persona != null) {
            personaJuridicaService.delete(id);
        } else {
            return new ResponseEntity<ClientePersonaJuridica>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<ClientePersonaJuridica>(persona, HttpStatus.OK);
    }
}
