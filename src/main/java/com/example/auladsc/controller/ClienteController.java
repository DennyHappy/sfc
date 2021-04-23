package com.example.auladsc.controller;

import com.example.auladsc.model.*;
import com.example.auladsc.service.ClienteService;
import com.example.auladsc.service.CompraService;
import com.example.auladsc.service.CupomService;
import com.example.auladsc.service.PromocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class ClienteController {

    @Autowired
    ClienteService service;

    @Autowired
    CompraService service_compra;

    @Autowired
    PromocaoService service_promo;

    @Autowired
    CupomService service_cupom;

    /*
    * Lista todos os clientes
    * @return
    * */
    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public ModelAndView getClientes(){
        ModelAndView mv = new ModelAndView("clientes");
        List<Cliente> clientes = service.findAll();
        mv.addObject("clientes", clientes);
        return mv;
    }

    /*
     * Exibe formulario de cadastro de Cliente
     * @return
     * */
    @RequestMapping(value = "/cadastrarCliente", method = RequestMethod.GET)
    public String exibirFormulario(){
        return "form_cadastro_cliente";
    }

    /*
     * Cadastra o Cliente no banco
     * @return
     * */
    @RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST)
    public String CadastrarCliente(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos corretamente!");
            return "redirect:/cadastrarCliente";
        }
        cliente.setCompras(null);
        cliente.setMoedas(10);
        service.save(cliente);
        return "redirect:/clientes";
    }

    /*
     * Mostra Perfil do Cliente
     * @return
     * */
    @RequestMapping(value="cliente/{id}", method = RequestMethod.GET)
    public ModelAndView verPerfil(@PathVariable("id") long id){
        Cliente cli = service.findById(id);
        ModelAndView mv = new ModelAndView("perfil_cliente");
        mv.addObject("cli", cli);

        Iterable<Compra> compras = service_compra.findByCliente(cli);
        mv.addObject("compras", compras);

        return mv;
    }

    @RequestMapping("/dados_promocao_cliente/{id}")
    public String dados_promocao_cliente(){
        return "dados_promocao_cliente";
    }

    @RequestMapping(value = "/dados_promocao_cliente/{id}", method = RequestMethod.GET)
    public ModelAndView mostraIdCliente(@PathVariable("id") long id){
        ModelAndView model = new ModelAndView("dados_promocao_cliente");

        Cliente cli = service.findById(id);

        model.addObject("cli",cli);

        List<Promocao> promos = service_promo.listarPromocoesValidas(cli);

        List<Cupom> cupons_cliente = service_cupom.findByCliente(cli);

        List<Promocao> promos2 = new LinkedList<Promocao>();

        for (Promocao promo: promos) {
            for (Cupom cupom: cupons_cliente) {
                if (promo.getId() == cupom.getPromocao().getId()){
                    promos2.add(promo);
                    break;
                }
            }
        }

        promos.removeAll(promos2);

        model.addObject("promos",promos);

        return model;
    }

    @RequestMapping(value = "/resgatar_cupom/{id_cli}/{id_promo}", method = RequestMethod.GET)
    public ModelAndView resgatarCupom(@PathVariable("id_cli") long id_cli, @PathVariable("id_promo") long id_promo){
        ModelAndView model = new ModelAndView("dados_promocao_cliente");
        Cliente cli = service.findById(id_cli);
        Promocao promo_busca = service_promo.findById(id_promo);
        List<Cupom> cupons = promo_busca.getCupons();

        for(Cupom cupom : cupons) {
            if (cupom.getCliente() == null){
                cupom.setCliente(cli);
                service_cupom.save(cupom);
                break;
            }
        }

        model.addObject("cli",cli);

        List<Promocao> promos = service_promo.listarPromocoesValidas(cli);

        List<Cupom> cupons_cliente = service_cupom.findByCliente(cli);

        List<Promocao> promos2 = new LinkedList<Promocao>();

        for (Promocao promo: promos) {
            for (Cupom cupom: cupons_cliente) {
                if (promo.getId() == cupom.getPromocao().getId()){
                    promos2.add(promo);
                    break;
                }
            }
        }

        promos.removeAll(promos2);

        model.addObject("promos",promos);

        return model;
    }

}
