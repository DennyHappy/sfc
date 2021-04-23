package com.example.auladsc.testesItgrcServices;

import com.example.auladsc.model.Cliente;
import com.example.auladsc.model.Compra;
import com.example.auladsc.model.Cupom;
import com.example.auladsc.repository.ClienteRepository;
import com.example.auladsc.service.serviceImpl.ClienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


//@SpringBootTest(classes = ClienteServiceImplIT.class)
public class ClienteServiceImplIT {

//    @MockBean
//    ClienteRepository repository;
//
//    @Autowired
//    ClienteServiceImpl clienteService;
//
//    private Cliente cliente;
//    private List<Compra> comprasCliente = new LinkedList<Compra>();
//    private List<Cupom> cuponsCliente = new LinkedList<Cupom>();
//
//    private Cliente clienteBusca;
//
//    @BeforeEach
//    public void setUp() throws Exception{
//        //Cliente
//        cliente.setId(1L);
//        cliente.setNome("Denilson Medeiros");
//        cliente.setCpf("702.462.846-32");
//        cliente.setMoedas(0);
//        cliente.setCompras(comprasCliente);
//        cliente.setCupons(cuponsCliente);
//
////        this.clientes.add(cliente);
//
//        this.clienteBusca = this.cliente;
//    }
//
//    /**
//     * Testa o método que busca o cliente por ID, e retorna um cliente
//     */
//    @Test
//    public void testFindById(){
//
//        Cliente clienteMockado = new Cliente();
//        /**
//         * Adiciona a clienteMockado o retorno do método findById() chamado pelo repository
//         * passando um ID
//         */
//        doReturn(clienteMockado)
//                .when(repository)
//                .findById(this.clienteBusca.getId());
//
//        /**
//         * execução do método findById()
//         */
//        Cliente clienteRetornado = clienteService.findById(clienteBusca.getId());
//
//        /**
//         * Verifica com assertThat() se o clienteRetornado é igual ao clienteMockado usando o .isSameAs()
//         */
//        assertThat(clienteRetornado).isSameAs(clienteMockado);
//    }
//
//    /**
//     * Testa o método que busca o cliente por CPF, e retorna um cliente
//     */
//    @Test
//    public void testFindByCpf(){
//
//        Cliente clienteMockado = new Cliente();
//        /**
//         * Adiciona a clienteMockado o retorno do método findByCpf() chamado pelo repository
//         * passando um CPF
//         */
//        doReturn(clienteMockado)
//                .when(repository)
//                .findByCpf(this.clienteBusca.getCpf());
//
//        /**
//         * execução do método findByCpf()
//         */
//        Cliente clienteRetornado = clienteService.findByCpf(clienteBusca.getCpf());
//
//        /**
//         * Verifica com assertThat() se o clienteRetornado é igual ao clienteMockado usando o .isSameAs()
//         */
//        assertThat(clienteRetornado).isSameAs(clienteMockado);
//    }
//
//    /**
//     * Testa o método que salva um cliente no banco de dados passando um cliente
//     */
//    @Test
//    public void testSave(){
//
//        Cliente clienteMockado = new Cliente();
//        /**
//         * Adiciona a clienteMockado o retorno do método save() chamado pelo repository
//         * passando um cliente
//         */
//        doReturn(clienteMockado)
//                .when(repository)
//                .save(cliente);
//
//        /**
//         * execução do método save()
//         */
//        Cliente clienteSalvo = clienteService.save(cliente);
//
//        /**
//         * Verifica com assertThat() se o clienteSalvo é igual ao clienteMockado usando o .isSameAs()
//         */
//        assertThat(clienteSalvo).isSameAs(clienteMockado);
//    }
}
