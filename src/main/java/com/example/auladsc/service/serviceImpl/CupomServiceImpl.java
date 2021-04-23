package com.example.auladsc.service.serviceImpl;

import com.example.auladsc.model.Cliente;
import com.example.auladsc.model.Cupom;
import com.example.auladsc.model.Promocao;
import com.example.auladsc.repository.CupomRepository;
import com.example.auladsc.service.CupomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CupomServiceImpl implements CupomService {

    @Autowired
    CupomRepository repository;

    @Override
    public List<Cupom> findAll() {

        return repository.findAll();
    }

    @Override
    public Cupom findById(Long id) {

        return repository.findById(id).get();
    }

    @Override
    public Cupom save(Cupom cpm) {

        return repository.save(cpm);
    }

    @Override
    public List<Cupom> findByCliente(Cliente cliente) {

        return repository.findByCliente(cliente);
    }

    @Override
    public List<Cupom> listarCuponsDisponiveis(Promocao promocao,Cliente cliente) {
        List<Cupom> cuponsValidos = promocao.getCupons().stream().filter(c -> c.getCliente() == null).collect(Collectors.toList());
        return cuponsValidos;
    }
}
