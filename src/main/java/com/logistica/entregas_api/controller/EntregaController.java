package com.logistica.entregas_api.controller;

import com.logistica.entregas_api.dto.EntregaRequestDTO;
import com.logistica.entregas_api.model.Entrega;
import com.logistica.entregas_api.service.EntregaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @PostMapping
    public ResponseEntity<Entrega> criarEntrega(@Valid @RequestBody EntregaRequestDTO dto) {
        Entrega novaEntrega = entregaService.criarEntrega(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEntrega);
    }
}