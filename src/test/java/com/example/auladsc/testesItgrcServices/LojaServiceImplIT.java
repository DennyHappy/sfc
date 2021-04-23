package com.example.auladsc.testesItgrcServices;

import com.example.auladsc.model.*;
import com.example.auladsc.repository.LojaRepository;
import com.example.auladsc.service.serviceImpl.LojaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

//@SpringBootTest(classes = LojaServiceImplIT.class)
public class LojaServiceImplIT {

//    @MockBean
//    LojaRepository repository;
//
//    @Autowired
//    LojaServiceImpl lojaService;
//
//    private Loja loja = new Loja();
//    private List<Promocao> promocoes = new LinkedList<Promocao>();
//    private List<Compra> comprasLoja = new LinkedList<Compra>();
//
//    private Loja lojaBusca;
//
//    @BeforeEach
//    public void setUp() throws Exception{
//
//        //Loja
//        loja.setId(1L);
//        loja.setCnpj("735284375682839238");
//        loja.setNome("Lojao do Jeans");
//        loja.setClassificacao("ROUPAS");
//        loja.setCompras(comprasLoja);
//        loja.setPromocoes(promocoes);
//
//        this.lojaBusca = this.loja;
//    }
//
//    /**
//     * Testa o método que busca a loja por ID, e retorna uma loja
//     */
//    @Test
//    public void testFindById(){
//
//        Loja lojaMockada = new Loja();
//        /**
//         * Adiciona a lojaMockada o retorno do método findById() chamado pelo repository
//         * passando um ID
//         */
//        doReturn(lojaMockada)
//                .when(repository)
//                .findById(this.lojaBusca.getId());
//
//        /**
//         * execução do método findById()
//         */
//        Loja lojaRetornada = lojaService.findById(lojaBusca.getId());
//
//        /**
//         * Verifica com assertThat() se o lojaRetornada é igual a lojaMockada usando o .isSameAs()
//         */
//        assertThat(lojaRetornada).isSameAs(lojaMockada);
//    }
//
//    /**
//     * Testa o método que busca a loja pelo CNPJ, e retorna uma loja
//     */
//    @Test
//    public void testFindByCnpj(){
//
//        Loja lojaMockada = new Loja();
//        /**
//         * Adiciona a lojaMockada o retorno do método findByCnpj() chamado pelo repository
//         * passando um CNPJ
//         */
//        doReturn(lojaMockada)
//                .when(repository)
//                .findByCnpj(this.lojaBusca.getCnpj());
//
//        /**
//         * execução do método testFindByCnpj()
//         */
//        Loja lojaRetornada = lojaService.findByCnpj(lojaBusca.getCnpj());
//
//        /**
//         * Verifica com assertThat() se o lojaRetornada é igual a lojaMockada usando o .isSameAs()
//         */
//        assertThat(lojaRetornada).isSameAs(lojaMockada);
//    }
//
//    /**
//     * Testa o método que salva um cliente no banco de dados passando um cliente
//     */
//    @Test
//    public void testSave(){
//
//        Loja lojaMockada = new Loja();
//        /**
//         * Adiciona a lojaMockada o retorno do método save() chamado pelo repository
//         * passando uma loja
//         */
//        doReturn(lojaMockada)
//                .when(repository)
//                .save(loja);
//
//        /**
//         * execução do método save()
//         */
//        Loja lojaSalva = lojaService.save(loja);
//
//        /**
//         * Verifica com assertThat() se a lojaSalva é igual a lojaMockada usando o .isSameAs()
//         */
//        assertThat(lojaSalva).isSameAs(lojaMockada);
//    }
}
