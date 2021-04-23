package com.example.auladsc.service.serviceImpl;

import com.example.auladsc.model.Cliente;
import com.example.auladsc.model.Compra;
import com.example.auladsc.model.Loja;
import com.example.auladsc.repository.CompraRepository;
import com.example.auladsc.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    CompraRepository repository;

    @Override
    public List<Compra> findAll() {

        return repository.findAll();
    }

    @Override
    public Compra findById(Long id) {

        return repository.findById(id).get();
    }

    @Override
    public Compra save(Compra cmp) {

        return repository.save(cmp);
    }

    @Override
    public Iterable<Compra> findByCliente(Cliente cliente) {

        return repository.findByCliente(cliente);
    }

    @Override
    public Iterable<Compra> findByLoja(Loja loja) {

        return repository.findByLoja(loja);
    }
}
