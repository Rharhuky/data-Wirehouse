package com.datawareHouse.controllers;

import com.datawareHouse.model.cassandra.Venda;
import com.datawareHouse.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@RestController
@RequestMapping("/venda")
public class VendaController {

    private final VendaRepository vendaRepository;

    @PostMapping
    public ResponseEntity<Venda> adicionarVenda(@RequestBody Venda venda) {
        venda.setIdVenda(UUID.randomUUID());
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaRepository.save(venda));
    }

    @GetMapping
    public ResponseEntity<List<Venda>> listarVendas() {
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaRepository.findAll());
    }
    
}
