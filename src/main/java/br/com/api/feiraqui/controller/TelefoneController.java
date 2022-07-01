package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.DAO.ITelefone;
import br.com.api.feiraqui.model.Telefone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TelefoneController {

    @Autowired
    private ITelefone dao;

    @GetMapping("/telefones")
    public List<Telefone> listaTelefones (){
        return (List<Telefone>) dao.findAll();
    }


}
