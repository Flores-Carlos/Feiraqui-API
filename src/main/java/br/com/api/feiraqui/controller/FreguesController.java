package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.DAO.IFregues;
import br.com.api.feiraqui.model.Fregues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FreguesController {

    @Autowired
    private IFregues dao;

    @GetMapping("/fregueses")
    public List<Fregues> listaFregueses (){

        return (List<Fregues>) dao.findAll();
    }

}
