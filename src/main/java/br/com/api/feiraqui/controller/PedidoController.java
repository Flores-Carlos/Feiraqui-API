package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.DAO.IPedido;
import br.com.api.feiraqui.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private IPedido dao;

    @GetMapping("/pedidos")
    public List<Pedido> listaPedidos (){

        return (List<Pedido>) dao.findAll();
    }

}
