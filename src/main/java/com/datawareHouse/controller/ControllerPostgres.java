package com.datawareHouse.controller;

import com.datawareHouse.model.postgres.CidadeDataWare;
import com.datawareHouse.service.CidadeDataWareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postgre")
public class ControllerPostgres {

    @Autowired
    private CidadeDataWareService service;


    @PostMapping
    public CidadeDataWare criarCidade(@RequestBody CidadeDataWare cidade){

        return this.service.criarCidadeDataWare(cidade);

    }

    @GetMapping
    public List<CidadeDataWare> verCidades(){
        return this.service.verCidades();
    }


}
