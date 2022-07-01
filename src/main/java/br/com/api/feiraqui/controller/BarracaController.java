package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.DAO.IBarraca;
import br.com.api.feiraqui.model.Barraca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BarracaController {

    @Autowired
    private IBarraca dao;

    @GetMapping("/barracas")
    public List<Barraca> listaBarracas (){

        return (List<Barraca>) dao.findAll();
    }
}
