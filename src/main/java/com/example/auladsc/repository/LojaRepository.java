package com.example.auladsc.repository;

import com.example.auladsc.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long>{//, QuerydslPredicateExecutor<Loja> {

    Loja findByCnpj(String cnpj);      //Método buscar loja pelo cnpj
}
