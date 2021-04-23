package com.example.auladsc.controller;

import com.example.auladsc.model.*;
import com.example.auladsc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

@Controller
public class LojaController {

    @Autowired
    LojaService service;

    @Autowired
    ClienteService service_cliente;

    @Autowired
    CompraService service_compra;

    @Autowired
    PromocaoService service_promocao;

    @Autowired
    CupomService service_cupom;

    /*
     * Lista todas as lojas
     * @return
     * */
    @RequestMapping(value = "/lojas", method = RequestMethod.GET)
    public ModelAndView getLojas() {
        ModelAndView mv = new ModelAndView("lojas");
        List<Loja> lojas = service.findAll();
        mv.addObject("lojas", lojas);
        return mv;
    }

    /*
     * Exibe formulario de cadastro de Loja
     * @return
     * */
    @RequestMapping(value = "/cadastrarLoja", method = RequestMethod.GET)
    public String exibirFormulario() {
        return "form_cadastro_loja";
    }

    /*
     * Cadastra o Loja no banco
     * @return
     * */
    @RequestMapping(value = "/cadastrarLoja", method = RequestMethod.POST)
    public String cadastrarLoja(@Valid Loja loja, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos corretamente!");
            return "redirect:/cadastrarLoja";
        }
        service.save(loja);
        return "redirect:/lojas";
    }

    /*
     * Mostra Perfil da Loja
     * @return
     * */
    @RequestMapping(value = "loja/{id}", method = RequestMethod.GET)
    public ModelAndView verPerfilLoja(@PathVariable("id") long id) {
        Loja lj = service.findById(id);
        ModelAndView mv = new ModelAndView("perfil_loja");
        mv.addObject("lj", lj);

        return mv;
    }

    /**
     * Mostra a pagina de dados do cliente no perfil da loja
     * @return
     */
    @RequestMapping("/dados_cliente/{id}")
    public String dados_cliente(){
        return "dados_cliente";
    }

    /**
     * Insere o identificador da loja dentro da pagina de dados do cliente
     * @param id
     * @return
     */
    @RequestMapping(value = "/dados_cliente/{id}", method = RequestMethod.GET)
    public ModelAndView getLoja(@PathVariable("id") long id) {
        Loja lj = service.findById(id);
        ModelAndView mv = new ModelAndView("dados_cliente");
        mv.addObject("lj", lj);
        return mv;
    }

    /**
     * Busca os dados do cliente via POST, o identificador da loja e
     * insere dentro da pagina de dados do cliente
     * @param id
     * @param cliente
     * @return
     */
    @RequestMapping(value = "/buscarCliente/{id}", method = RequestMethod.POST)
    public ModelAndView buscarCliente(@PathVariable("id") long id,Cliente cliente) {
        ModelAndView model = new ModelAndView("/dados_cliente");
        Cliente cli = service_cliente.findByCpf(cliente.getCpf());
        model.addObject("cli", cli);

        if (cliente.getCpf().equals("")){
            model.addObject("msg_busca", "Verifique se o campo de busca foi preenchido corretamente!");

            Iterable<Compra> compras_cli = service_compra.findByCliente(cli);
            model.addObject("compras_cli", compras_cli);

            Loja lj = service.findById(id);
            model.addObject("lj", lj);
            return model;
        }else
        if(cli == null){
            model.addObject("msg_busca", "Usuário não encontrado!");

            Iterable<Compra> compras_cli = service_compra.findByCliente(cli);
            model.addObject("compras_cli", compras_cli);

            Loja lj = service.findById(id);
            model.addObject("lj", lj);
            return model;
        }else{
            Iterable<Compra> compras_cli = service_compra.findByCliente(cli);
            model.addObject("compras_cli", compras_cli);

            Loja lj = service.findById(id);
            model.addObject("lj", lj);
            return model;
        }

    }

    /*
     * Cadastra Compra
     * @return
     * */
    @RequestMapping(value="cadastrarCompra/{id_lj}/{id_cli}", method = RequestMethod.POST)
    public ModelAndView cadastrarCompra(@PathVariable("id_lj") long id_lj, @PathVariable("id_cli") long id_cli, Compra cmp,String valor_compra){
        ModelAndView model = new ModelAndView("/dados_cliente");
        Cliente cli = service_cliente.findById(id_cli);
        model.addObject("cli", cli);

        System.out.println(valor_compra);

        Loja lj = service.findById(id_lj);
        model.addObject("lj", lj);

        cmp.setData(LocalDate.now());
        cmp.setValor(Double.parseDouble(valor_compra));
        cmp.setCliente(cli);
        cmp.setLoja(lj);
        service_compra.save(cmp);

        Iterable<Compra> compras_cli = service_compra.findByCliente(cli);
        model.addObject("compras_cli", compras_cli);
        return model;
    }

    @RequestMapping("/dados_promocao/{id}")
    public String dados_promocao(){
        return "dados_promocao";
    }

    @RequestMapping(value = "dados_promocao/{id}", method = RequestMethod.GET)
    public ModelAndView mostraIdLoja(@PathVariable("id") long id){
        ModelAndView model = new ModelAndView("dados_promocao");

        Loja lj = service.findById(id);

        model.addObject("lj",lj);

        Iterable<Promocao> promocoes = service_promocao.findByLoja(lj);
        model.addObject("promocoes", promocoes);

        return model;
    }

    /*
     * Cadastra Promoção
     * @return
     * */
    @RequestMapping(value="cadastrarPromocao/{id_lj}", method = RequestMethod.POST)
    public ModelAndView cadastrarPromocao(@PathVariable("id_lj") long id_lj, Promocao pmc, String data){
        ModelAndView model = new ModelAndView("/dados_cupom");
//        List<Cupom> cupons = new LinkedList<Cupom>();

        System.out.println(data);

        int ano = Integer.parseInt(data.substring(0,4));
        int mes = Integer.parseInt(data.substring(5,7));
        int dia = Integer.parseInt(data.substring(8,10));

//        System.out.println(ano);
//        System.out.println(mes);
//        System.out.println(dia);

        LocalDate dt1 = LocalDate.of(ano,mes,dia);

//        System.out.println(dt1);

        Loja lj = service.findById(id_lj);
//
        pmc.setData_validade(dt1);
        pmc.setLoja(lj);
        pmc.setCupons(null);

        Promocao pmc2 = service_promocao.save(pmc);

        model.addObject("lj", lj);

        model.addObject("pmc", pmc2);

        return model;
    }

    @RequestMapping(value="deletar_promocao/{id_pmc}/{id_lj}", method = RequestMethod.GET)
    public ModelAndView deletarPromocao(@PathVariable("id_pmc") long id_pmc,@PathVariable("id_lj") long id_lj){
        ModelAndView model = new ModelAndView("dados_promocao");
        service_promocao.deleteById(id_pmc);

        Loja lj = service.findById(id_lj);
        Iterable<Promocao> promocoes = service_promocao.findByLoja(lj);

        model.addObject("lj",lj);

        model.addObject("promocoes", promocoes);

        return model;
    }

    /*
     * Cadastra Cupons
     * @return
     * */
    @RequestMapping(value="cadastrarCupons/{id_pmc}/{id_lj}", method = RequestMethod.POST)
    public ModelAndView cadastrarCupons(@PathVariable("id_pmc") long id_pmc,@PathVariable("id_lj") long id_lj, int quantidade_cupons){
        ModelAndView model = new ModelAndView("/dados_promocao");

        Promocao pmc_cadastrada = service_promocao.findById(id_pmc);
        List<Cupom> cupons = new LinkedList<Cupom>();

        for (int i = 0; i < quantidade_cupons; i++) {
            Cupom cpm = new Cupom();
            cpm.setPromocao(pmc_cadastrada);
            service_cupom.save(cpm);
            cupons.add(cpm);
        }
        pmc_cadastrada.setCupons(cupons);
        service_promocao.save(pmc_cadastrada);

        Loja lj = service.findById(id_lj);
        Iterable<Promocao> promocoes = service_promocao.findByLoja(lj);

        model.addObject("lj",lj);

        model.addObject("promocoes", promocoes);

        return model;
    }
}