package com.example.auladsc.repository;

import com.example.auladsc.model.Cliente;
import com.example.auladsc.model.Cupom;
import com.example.auladsc.model.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long>, QuerydslPredicateExecutor<Cupom> {

    List<Cupom> findByCliente(Cliente cliente);     //Método listar cupons pegos por um cliente
}
