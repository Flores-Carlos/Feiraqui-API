package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.DAO.IEntregador;
import br.com.api.feiraqui.model.Entregador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntregadorController {

    @Autowired
    private IEntregador dao;

    @GetMapping("/entregadores")
    public List<Entregador> listaEntregadores (){

        return (List<Entregador>) dao.findAll();
    }

}
