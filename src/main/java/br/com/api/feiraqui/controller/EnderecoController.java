package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.DAO.IEndereco;
import br.com.api.feiraqui.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnderecoController {

    @Autowired
    private IEndereco dao;

    @GetMapping("/enderecos")
    public List<Endereco> listaEnderecos (){
        return (List<Endereco>) dao.findAll();
    }
}
