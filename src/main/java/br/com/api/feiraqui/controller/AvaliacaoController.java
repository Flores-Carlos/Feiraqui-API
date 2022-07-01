package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.DAO.IAvaliacao;
import br.com.api.feiraqui.model.Avaliacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AvaliacaoController {

    @Autowired
    private IAvaliacao dao;

    @GetMapping("/avaliacoes")
    public List<Avaliacao> listaMercadorias (){

        return (List<Avaliacao>) dao.findAll();
    }

}
