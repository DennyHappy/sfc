package com.example.auladsc.service.serviceImpl;

import com.example.auladsc.model.*;
import com.example.auladsc.repository.CupomRepository;
import com.example.auladsc.repository.PromocaoRepository;
import com.example.auladsc.service.CupomService;
import com.example.auladsc.service.PromocaoService;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PromocaoServiceImpl implements PromocaoService {

    @Autowired
    PromocaoRepository repository;

    @Autowired
    CupomService service_cupom;

    @Override
    public List<Promocao> findAll() {

        return repository.findAll();
    }

    @Override
    public Promocao findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Promocao save(Promocao pr) {
        return repository.save(pr);
    }

    @Override
    public Iterable<Promocao> findByLoja(Loja loja) {

        return repository.findByLoja(loja);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Promocao> listarPromocoesValidas(Cliente cliente) {
        QPromocao qPromocao = QPromocao.promocao;

        BooleanExpression expression = qPromocao.data_validade.goe(LocalDate.now());

        List<Promocao> promocoes = (List<Promocao>) repository.findAll(expression);

        for (Promocao p: promocoes) {
            List<Cupom> validos = service_cupom.listarCuponsDisponiveis(p,cliente);
            p.setCupons(validos);
        }

        return promocoes;
    }
}
