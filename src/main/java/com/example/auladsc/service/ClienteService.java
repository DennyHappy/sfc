package com.example.auladsc.service;

import java.util.List;

import com.example.auladsc.model.Cliente;
import org.springframework.stereotype.Service;


public interface ClienteService {

    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente save(Cliente cli);
    Cliente findByCpf(String cpf);

}
