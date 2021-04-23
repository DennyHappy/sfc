package com.example.auladsc.testesUntrDominio;

import static org.junit.Assert.*;

import com.example.auladsc.model.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class LojaTest {
    private Cliente cliente = new Cliente();

    private Loja loja = new Loja();

    private List<Compra> comprasLoja = new LinkedList<Compra>();
    private List<Compra> comprasCliente = new LinkedList<Compra>();

    private Promocao p1 = new Promocao();
    private List<Promocao> promocoes = new LinkedList<Promocao>();

    private Cupom cp1 = new Cupom();
    private List<Cupom> cuponsLoja = new LinkedList<Cupom>();
    private List<Cupom> cuponsCliente = new LinkedList<Cupom>();



    @Before
    public void setUp() throws Exception{
        //Cliente
        cliente.setId(1L);
        cliente.setNome("Denilson");
        cliente.setCpf("70246283408");
        cliente.setMoedas(100);
        cliente.setCompras(comprasCliente);
        cliente.setCupons(cuponsCliente);

        //Loja
        loja.setId(1L);
        loja.setCnpj("735284375682839238");
        loja.setNome("Lojao do Jeans");
        loja.setClassificacao("ROUPAS");
        loja.setCompras(comprasLoja);
        loja.setPromocoes(promocoes);

        //Promoção
        p1.setId(1L);
        p1.setDescricao("Desconto de 15% em camisas masculinas");
        p1.setData_validade(LocalDate.of(2021, 03, 30));
        p1.setValor_desconto(15);
        p1.setMoedas_necesssarias(150);
        p1.setLoja(loja);
        p1.setCupons(cuponsLoja);

        //Adicionando a lista de promoções da Loja
        promocoes.add(p1);

        //Cupom
        cp1.setId(1L);
        cp1.setPromocao(p1);
        cp1.setCliente(cliente);
    }

    @Test
    public void testValidaCupomComSucesso(){
        assertFalse(loja.validaCupom(cp1));
    }
}
