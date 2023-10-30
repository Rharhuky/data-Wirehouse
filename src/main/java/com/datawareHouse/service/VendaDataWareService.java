package com.datawareHouse.service;

import com.datawareHouse.model.VendaDataWare;
import com.datawareHouse.repository.VendaDataWareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VendaDataWareService {

    private final VendaDataWareRepository vendaDataWareRepository;
    private final ProdutoDataWareService produtoDataWareService;
    private final CidadeDataWareService cidadeDataWareService;

    @Autowired
    public VendaDataWareService(VendaDataWareRepository vendaDataWareRepository, ProdutoDataWareService produtoDataWareService, CidadeDataWareService cidadeDataWareService) {
        this.vendaDataWareRepository = vendaDataWareRepository;
        this.produtoDataWareService = produtoDataWareService;
        this.cidadeDataWareService = cidadeDataWareService;
    }

    public VendaDataWare criarVenda(VendaDataWare vendaDataWare){
        return this.vendaDataWareRepository.save(vendaDataWare);
    }
    public void deletarVendaDataWarePeloId(UUID id){
        VendaDataWare venda = this.vendaDataWareRepository.findById(id).orElseThrow(RuntimeException::new);
        this.vendaDataWareRepository.delete(venda);
    }

    public List<VendaDataWare> verVendas(){
        return this.vendaDataWareRepository.findAll();
    }

    public VendaDataWare verVendaDataWarePeloId(UUID id){
        return this.vendaDataWareRepository.findById(id).orElseThrow(RuntimeException::new);
    }


}
