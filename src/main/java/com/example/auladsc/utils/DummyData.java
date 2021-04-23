package com.example.auladsc.utils;

import com.example.auladsc.model.Cupom;
import com.example.auladsc.model.Loja;
import com.example.auladsc.model.Promocao;
import com.example.auladsc.service.LojaService;
import com.example.auladsc.service.PromocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Component
public class DummyData {

//    @Autowired
//    PromocaoService service;
//
//    @Autowired
//    LojaService service_loja;
//
//    @PostConstruct
//    public void criarPromocao(){
//        List<Cupom> cupons = new LinkedList<Cupom>();
//        Loja lj = service_loja.findById(3L);
//
//        Promocao promo = Promocao.builder()
//                .descricao("15% de desconto em camisas sociais")
//                .data_validade(LocalDate.of(2021,04,17))
//                .valor_desconto(15)
//                .moedas_necesssarias(30)
//                .loja(lj)
//                .cupons(cupons)
//                .build();
//
//        service.save(promo);
//    }
//    @Autowired
//    ClienteRepository repository;
//
//    @Autowired
//    CompraRepository repository2;
//
////    @PostConstruct
//    public void salvarCliente(){
//        List<Compra> compras = new LinkedList<>();
//
//        Cliente cliente = Cliente.builder()
//                .cpf("70246283408")
//                .nome("Denilson")
//                .moedas(0)
//                .compras(compras)
//                .build();
//
//        //Salvar Cliente usando repository.save()
//        Cliente clienteSalvo = repository.save(cliente);
//        System.out.println("CPF: " + clienteSalvo.getCpf());
//    }
//
////    @PostConstruct
//    public void salvarCompra(){
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDateTime now = LocalDateTime.now();
//
//        //Optional<Cliente> c = repository.findById(70246283408L);
//
//        Compra compra = Compra.builder()
//                .descricao("Camisa Social Azul")
//                .valor(35)
//                .classificacao(Classificacao.ROUPA)
//                .data(LocalDate.parse(dtf.format(now)))
//                .cliente(repository.findById(70246283408L).get())
//                .build();
//
//        //Salvar Cliente usando repository.save()
//        Compra compraSalva = repository2.save(compra);
//        System.out.println("Id Compra: " + compraSalva.getId());
//
//        Compra compra2 = Compra.builder()
//                .descricao("Tenis Adidas")
//                .valor(116)
//                .classificacao(Classificacao.CALÇADO)
//                .data(LocalDate.parse(dtf.format(now)))
//                .cliente(repository.findById(70246283408L).get())
//                .build();
//
//        //Salvar Cliente usando repository.save()
//        Compra compraSalva2 = repository2.save(compra2);
//        System.out.println("Id Compra: " + compraSalva2.getId());
//    }





}
