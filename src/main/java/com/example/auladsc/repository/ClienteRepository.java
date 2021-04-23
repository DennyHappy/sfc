package com.example.auladsc.repository;

import com.example.auladsc.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{//, QuerydslPredicateExecutor<Cliente> {

    Cliente findByCpf(String cpf);      //Método buscar cliente pelo cpf
}
