package com.example.auladsc.service;

import com.example.auladsc.model.Cliente;
import com.example.auladsc.model.Loja;
import com.example.auladsc.model.Promocao;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PromocaoService {

    List<Promocao> findAll();
    Promocao findById(Long id);
    Promocao save(Promocao pr);
    Iterable<Promocao> findByLoja(Loja loja);
    void deleteById(Long id);

    List<Promocao> listarPromocoesValidas(Cliente cliente);    //Lista as promoções válidas

}
