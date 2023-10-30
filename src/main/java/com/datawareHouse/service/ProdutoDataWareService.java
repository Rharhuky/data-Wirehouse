package com.datawareHouse.service;

import com.datawareHouse.model.postgres.ProdutoDataWare;
import com.datawareHouse.model.postgres.VendaDataWare;
import com.datawareHouse.repository.ProdutoDataWareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoDataWareService {
    private final ProdutoDataWareRepository produtoDataWareRepository;

    @Autowired
    public ProdutoDataWareService(ProdutoDataWareRepository produtoDataWareRepository) {
        this.produtoDataWareRepository = produtoDataWareRepository;
    }

    public ProdutoDataWare criarProdutoDataWare(ProdutoDataWare produtoDataWare){

        return this.produtoDataWareRepository.save(produtoDataWare);
    }

    public ProdutoDataWare verProdutoDataWarePeloId(UUID id){
        return this.produtoDataWareRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public ProdutoDataWare verProdutoPeloNome(String nomeProduto){
        return this.produtoDataWareRepository.findByNome(nomeProduto);
    }

    public List<ProdutoDataWare> verProdutosDataWare(){
        return this.produtoDataWareRepository.findAll();
    }

    public void deletarProdutoDataWarePeloId(UUID id){

        ProdutoDataWare produtoDataWare = this.produtoDataWareRepository.findById(id).orElseThrow(RuntimeException::new);
        this.produtoDataWareRepository.delete(produtoDataWare);

    }
    public List<ProdutoDataWare> criarProdutos(List<ProdutoDataWare> novosProdutosDataWare){
        return this.produtoDataWareRepository.saveAll(novosProdutosDataWare);
    }

    public ProdutoDataWare atualizarProdutoDataWarePeloId(UUID id, ProdutoDataWare produtoDataWare){

        ProdutoDataWare produto = this.produtoDataWareRepository.findById(id).orElseThrow(RuntimeException::new);
        produto.setNome(produtoDataWare.getNome());
        produto.setPreco(produtoDataWare.getPreco());
        return this.produtoDataWareRepository.save(produto);

    }

}
