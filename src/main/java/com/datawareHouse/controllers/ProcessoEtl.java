package com.datawareHouse.controllers;

import com.datawareHouse.etlprocess.JsonGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor

@RestController
@RequestMapping("/processamento-etl")
public class ProcessoEtl {

    private final JsonGenerator jsonGenerator;

    @GetMapping
    public void processoETL() throws IOException {
        jsonGenerator.extraction();
        jsonGenerator.transform();
    }

}
