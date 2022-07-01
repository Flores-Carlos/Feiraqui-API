package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.DAO.IFeiraBarracas;
import br.com.api.feiraqui.model.FeiraBarracas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeiraBarracasController {

    @Autowired
    private IFeiraBarracas dao;

    @GetMapping("/feira-barracas")
    public List<FeiraBarracas> listaFeiraBarracas (){

        return (List<FeiraBarracas>) dao.findAll();
    }

}
