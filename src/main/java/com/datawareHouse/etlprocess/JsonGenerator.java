package com.datawareHouse.etlprocess;

import com.datawareHouse.model.cassandra.Cidade;
import com.datawareHouse.model.cassandra.Produto;
import com.datawareHouse.model.cassandra.Venda;
import com.datawareHouse.model.postgres.CidadeDataWare;
import com.datawareHouse.model.postgres.ProdutoDataWare;
import com.datawareHouse.model.postgres.Regiao;
import com.datawareHouse.model.postgres.VendaDataWare;
import com.datawareHouse.repository.CidadeRepository;
import com.datawareHouse.repository.ProdutoDataWareRepository;
import com.datawareHouse.repository.ProdutoRepository;
import com.datawareHouse.repository.VendaRepository;
import com.datawareHouse.service.CidadeDataWareService;
import com.datawareHouse.service.ProdutoDataWareService;
import com.datawareHouse.service.VendaDataWareService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor

@Component
public class JsonGenerator {

    // TODO ADICIONAR PERSISTÊNCIA DO POSTGRE AQUI!

    private final ProdutoDataWareService produtoServicePG;
    private final VendaDataWareService vendaServicePG;
    private final CidadeDataWareService cidadeServicePG;

    private final ProdutoRepository produtoRepository;
    private final VendaRepository vendaRepository;
    private final CidadeRepository cidadeRepository;

    private final ObjectMapper objectMapper;


    private final ProdutoDataWareRepository produtoDataWareRepository;

    public void transform() throws IOException {
        List<Produto> produtos = objectMapper.readValue(new File("produtos.json"), new TypeReference<>() {

        });

        List<Cidade> cidades = objectMapper.readValue(new File("cidades.json"), new TypeReference<>() {
        });

        List<Venda> vendas = objectMapper.readValue(new File("vendas.json"), new TypeReference<>() {
        });

        produtoDataWareRepository.saveAll(produtos.stream().map(this::mapToProdutoDataWare).toList());

        postgresPersist();
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


    /**
     * Persistencia no Postgres
     */
    public void postgresPersist(){

        List<ProdutoDataWare> produtosToPg = produtoRepository.findAll()
                .stream()
                .map(this::mapToProdutoDataWare)
                .toList();

        List<CidadeDataWare> cidadesToPg = cidadeRepository.findAll()
                .stream()
                .map(this::mapToCidadeDataWare)
                .toList();


        this.cidadeServicePG.criarCidades(cidadesToPg);
        this.produtoServicePG.criarProdutos((produtosToPg));


        List<VendaDataWare> vendasToPg = vendaRepository.findAll().stream()
                .map(this::mapToVendaDataWare)
                .toList();

        //persistir vendas

        this.vendaServicePG.criarVendas(vendasToPg);

    }

    private ProdutoDataWare mapToProdutoDataWare(Produto produto){

        ProdutoDataWare produtoDataWare = new ProdutoDataWare();
        produtoDataWare.setIdProduto(produto.getIdProduto());
        produtoDataWare.setNome(produto.getNome());
        return produtoDataWare;
    }

    private CidadeDataWare mapToCidadeDataWare(Cidade cidade){

        CidadeDataWare cidadeDataWare = new CidadeDataWare();
        cidadeDataWare.setIdCidade(cidade.getIdCidade());
        cidadeDataWare.setNome(cidade.getNome());
        cidadeDataWare.setRegiao(
                Regiao.valueOf(cidade.getRegiao().toUpperCase()
                ));
        return cidadeDataWare;
    }

    private VendaDataWare mapToVendaDataWare(Venda venda){

        VendaDataWare vendaDataWare = new VendaDataWare();

        ProdutoDataWare produtoDataWare = this.produtoServicePG.verProdutoPeloNome(venda.getProduto());
        if (produtoDataWare != null) {
            vendaDataWare.setProduto(produtoDataWare);
            produtoDataWare.getVendas().add(vendaDataWare);

        }

        CidadeDataWare cidadeDataWare = this.cidadeServicePG.verCidadePeloNome(venda.getCidade());
        cidadeDataWare.getVendas().add(vendaDataWare);
        vendaDataWare.setCidade(cidadeDataWare);

        return vendaDataWare;

    }




}
