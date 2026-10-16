package com.biolab.seguranca.controllers;

import com.biolab.seguranca.dto.ClienteDTO;
import com.biolab.seguranca.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ClienteController {
   private final ClienteService service;
    public ClienteController(ClienteService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<?> dto(){
        return ResponseEntity.ok("Olá");
    }

    @PostMapping
    public ResponseEntity<?> criarCliente(@RequestBody ClienteDTO dto){
        return ResponseEntity.ok(service.criarCliente(dto));
    }


}
