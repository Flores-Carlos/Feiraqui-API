package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.DAO.IFeirante;
import br.com.api.feiraqui.model.Feirante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeiranteController {

    @Autowired
    private IFeirante dao;

    @GetMapping("/feirantes")
    public List<Feirante> listaFeirantes (){

        return (List<Feirante>) dao.findAll();
    }

}
