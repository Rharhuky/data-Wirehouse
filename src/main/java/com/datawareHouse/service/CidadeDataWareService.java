package com.datawareHouse.service;

import com.datawareHouse.model.CidadeDataWare;
import com.datawareHouse.repository.CidadeDataWareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CidadeDataWareService {

    private CidadeDataWareRepository cidadeDataWareRepository;
    // TODO logica de relacao ( adicao e remocao) p/ uma venda

    @Autowired
    public CidadeDataWareService(CidadeDataWareRepository cidadeDataWareRepository) {
        this.cidadeDataWareRepository = cidadeDataWareRepository;
    }

    public CidadeDataWare criarCidadeDataWare(CidadeDataWare cidadeDataWare){
        return this.cidadeDataWareRepository.save(cidadeDataWare);
    }

    public CidadeDataWare verCidadeDataWarePeloId(UUID id) {
        return this.cidadeDataWareRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<CidadeDataWare> verCidades(){
        return this.cidadeDataWareRepository.findAll();
    }
    public void deletarCidadeDataWarePeloBy(UUID id){
        CidadeDataWare cidade = this.cidadeDataWareRepository.findById(id).orElseThrow(RuntimeException::new);
        this.cidadeDataWareRepository.delete(cidade);
    }

    public CidadeDataWare atualizarCidadeDataWarePeloId(UUID id, CidadeDataWare cidade){

        CidadeDataWare cidadeDataWare = this.cidadeDataWareRepository.findById(id).orElseThrow(RuntimeException::new);
        cidadeDataWare.setNome(cidade.getNome());
        cidadeDataWare.setRegiao(cidade.getRegiao());

        return this.cidadeDataWareRepository.save(cidadeDataWare);
    }
}
