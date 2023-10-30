package com.datawareHouse.controllers;

import com.datawareHouse.model.cassandra.Cidade;
import com.datawareHouse.repository.CidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/cidade")
public class CidadeController {

    private final CidadeRepository cidadeRepository;

    @PostMapping
    public ResponseEntity<Cidade> adicionarCidade(@RequestBody Cidade cidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeRepository.save(cidade));
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> listarCidades() {
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeRepository.findAll());
    }

}
