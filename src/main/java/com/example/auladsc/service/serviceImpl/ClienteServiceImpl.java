package com.example.auladsc.service.serviceImpl;

import java.util.List;

import com.example.auladsc.model.Cliente;
import com.example.auladsc.model.Compra;
import com.example.auladsc.repository.ClienteRepository;
import com.example.auladsc.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository repository;

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    /**
     * Método para buscas via GET
     * @param id
     * @return
     */
    @Override
    public Cliente findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Cliente save(Cliente cli) {
        return repository.save(cli);
    }

    /**
     * Métodos para busca via POST
     * @param cpf
     * @return
     */
    @Override
    public Cliente findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
