package br.com.api.feiraqui.service;

import br.com.api.feiraqui.model.Pedido;
import br.com.api.feiraqui.repository.IPedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {


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
