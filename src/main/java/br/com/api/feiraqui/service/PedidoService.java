package br.com.api.feiraqui.service;

import br.com.api.feiraqui.model.Pedido;
import br.com.api.feiraqui.repository.IPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private IPedido repository;

    public List<Pedido> listarPedido() {
        List<Pedido> lista = repository.findAll();
        return lista;
    }

    public Pedido criarPedido(Pedido pedido) {
        Pedido pedidoNovo = repository.save(pedido);
        return pedidoNovo;
    }

    public Pedido editarPedido(Pedido pedido) {
        Pedido pedidoNovo = repository.save(pedido);
        return pedidoNovo;
    }

    public boolean excluirPedido(long id) {
        repository.deleteById(id);
        return true;
    }
}
