package com.example.auladsc.service;

import com.example.auladsc.model.Cliente;
import com.example.auladsc.model.Compra;
import com.example.auladsc.model.Loja;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CompraService {

    List<Compra> findAll();
    Compra findById(Long id);
    Compra save(Compra cmp);
    Iterable<Compra> findByCliente(Cliente cliente);
    Iterable<Compra> findByLoja(Loja loja);
}
