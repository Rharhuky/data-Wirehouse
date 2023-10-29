package com.datawareHouse.etlprocess;

import com.datawareHouse.model.cassandra.Cidade;
import com.datawareHouse.model.cassandra.Produto;
import com.datawareHouse.model.cassandra.Venda;
import com.datawareHouse.repository.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@RequiredArgsConstructor

@Component
public class JsonGenerator {

    // TODO ADICIONAR PERSISTÊNCIA DO POSTGRE AQUI!

//    private final ProdutoRepositoryPG produtoRepositoryPG;
//    private final VendaRepositoryPG vendaRepositoryPG;
//    private final CidadeRepositoryPG cidadeRepositoryPG;

    private final ProdutoRepository produtoRepository;
    private final VendaRepository vendaRepository;
    private final CidadeRepository cidadeRepository;

    private final ObjectMapper objectMapper;

    public void transform() throws IOException {
        List<Produto> produtos = objectMapper.readValue(new File("produtos.json"), new TypeReference<>() {
        });

        List<Cidade> cidades = objectMapper.readValue(new File("cidades.json"), new TypeReference<>() {
        });

        List<Venda> vendas = objectMapper.readValue(new File("vendas.json"), new TypeReference<>() {
        });

        vendaRepository.saveAll(vendas);
    }

    public void extraction() throws IOException {
        List<Produto> produtos = produtoRepository.findAll();
        List<Cidade> cidades = cidadeRepository.findAll();
        List<Venda> vendas = vendaRepository.findAll();

        File produtosJson = new File("produtos.json");
        objectMapper.writeValue(produtosJson, produtos);


        File cidadesJson = new File("cidades.json");
        objectMapper.writeValue(cidadesJson, cidades);


        File vendasJson = new File("vendas.json");
        objectMapper.writeValue(vendasJson, vendas);

    }


}
