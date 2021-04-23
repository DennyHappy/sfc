package com.example.auladsc.service;

import com.example.auladsc.model.Loja;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LojaService {

    List<Loja> findAll();
    Loja findById(Long id);
    Loja save(Loja lj);
    Loja findByCnpj(String cnpj);
}
