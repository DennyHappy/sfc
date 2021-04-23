package com.example.auladsc.repository;

import com.example.auladsc.model.Cliente;
import com.example.auladsc.model.Compra;
import com.example.auladsc.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{//, QuerydslPredicateExecutor<Compra> {

    Iterable<Compra> findByCliente(Cliente cliente);    //Método listar compras do cliente
    Iterable<Compra> findByLoja(Loja loja);       //Método listar compras da loja

//    Iterable<Compra> listarComprasPorMesDeUmCliente(Cliente cliente, String mes);


}
