package com.example.auladsc.service;

import com.example.auladsc.model.Cliente;
import com.example.auladsc.model.Cupom;
import com.example.auladsc.model.Promocao;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CupomService {

    List<Cupom> findAll();
    Cupom findById(Long id);
    Cupom save(Cupom cpm);
    List<Cupom> findByCliente(Cliente cliente);

    List<Cupom> listarCuponsDisponiveis(Promocao promocao,Cliente cliente);     //Lista os cupons disponiveis de uma promoção
}
