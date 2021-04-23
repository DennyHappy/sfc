package com.example.auladsc.repository;

import com.example.auladsc.model.Loja;
import com.example.auladsc.model.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Long>, QuerydslPredicateExecutor<Promocao> {

    Iterable<Promocao> findByLoja(Loja loja);       //Método listar promoções da loja

}
