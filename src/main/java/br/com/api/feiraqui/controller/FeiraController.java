package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.DAO.IFeira;
import br.com.api.feiraqui.model.Feira;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeiraController {

    @Autowired
    private IFeira dao;

    @GetMapping("/feiras")
    public List<Feira> listaFeiras (){
        return (List<Feira>) dao.findAll();
    }

}
