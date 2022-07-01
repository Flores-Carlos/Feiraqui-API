package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.DAO.IConta;
import br.com.api.feiraqui.model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContaController {

    @Autowired
    private IConta dao;

    @GetMapping("/contas")
    public List<Conta> listaConta (){

        return (List<Conta>) dao.findAll();
    }

}