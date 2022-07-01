package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.DAO.IMercadoria;
import br.com.api.feiraqui.model.Mercadoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MercadoriaController {

    @Autowired
    private IMercadoria dao;

    @GetMapping("/mercadorias")
    public List<Mercadoria> listaMercadorias (){

        return (List<Mercadoria>) dao.findAll();
    }

}
