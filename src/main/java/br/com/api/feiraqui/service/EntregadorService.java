package br.com.api.feiraqui.service;

import br.com.api.feiraqui.model.Entregador;
import br.com.api.feiraqui.repository.IEntregador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregadorService {


    private IEntregador repository;

    public List<Entregador> listarEntregador() {
        List<Entregador> lista = repository.findAll();
        return lista;
    }

    public Entregador criarEntregador(Entregador entregador) {
        Entregador entregadorNovo = repository.save(entregador);
        return entregadorNovo;
    }

    public Entregador editarEntregador(Entregador entregador) {
        Entregador entregadorNovo = repository.save(entregador);
        return entregadorNovo;
    }

    public boolean excluirEntregador(long id) {
        repository.deleteById(id);
        return true;
    }
}
