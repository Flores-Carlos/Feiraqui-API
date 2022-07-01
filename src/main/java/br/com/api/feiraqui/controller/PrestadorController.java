package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.DAO.IPrestador;
import br.com.api.feiraqui.model.Prestador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrestadorController {

    @Autowired
    private IPrestador dao;

    @GetMapping("/prestadores")
    public List<Prestador> listaPrestadores (){

        return (List<Prestador>) dao.findAll();
    }

}
