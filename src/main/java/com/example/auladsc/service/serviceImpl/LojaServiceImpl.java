package com.example.auladsc.service.serviceImpl;

import com.example.auladsc.model.Loja;
import com.example.auladsc.repository.LojaRepository;
import com.example.auladsc.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojaServiceImpl implements LojaService {

    @Autowired
    LojaRepository repository;

    @Override
    public List<Loja> findAll() {
        return repository.findAll();
    }

    /**
     * Método para buscas via GET
     * @param id
     * @return
     */
    @Override
    public Loja findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Loja save(Loja lj) {
        return repository.save(lj);
    }

    /**
     * Métodos para busca via POST
     * @param cnpj
     * @return
     */
    @Override
    public Loja findByCnpj(String cnpj) {
        return repository.findByCnpj(cnpj);
    }
}
