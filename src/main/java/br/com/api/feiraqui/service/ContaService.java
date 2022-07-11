package br.com.api.feiraqui.service;

import br.com.api.feiraqui.model.Conta;
import br.com.api.feiraqui.repository.IConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private IConta repository;

    public List<Conta> listarConta() {
        List<Conta> lista = repository.findAll();
        return lista;
    }

    public Conta criarConta(Conta conta) {
        Conta contaNovo = repository.save(conta);
        return contaNovo;
    }

    public Conta editarConta(Conta conta) {
        Conta contaNovo = repository.save(conta);
        return contaNovo;
    }

    public boolean excluirConta(long id) {
        repository.deleteById(id);
        return true;
    }
}
