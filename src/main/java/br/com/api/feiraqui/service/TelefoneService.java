package br.com.api.feiraqui.service;

import br.com.api.feiraqui.model.Telefone;
import br.com.api.feiraqui.repository.ITelefone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneService {

    @Autowired
    private ITelefone repository;

    public List<Telefone> listarTelefone() {
        List<Telefone> lista = repository.findAll();
        return lista;
    }

    public Telefone criarTelefone(Telefone telefone) {
        Telefone telefoneNovo = repository.save(telefone);
        return telefoneNovo;
    }

    public Telefone editarTelefone(Telefone telefone) {
        Telefone telefoneNovo = repository.save(telefone);
        return telefoneNovo;
    }

    public boolean excluirTelefone(long id) {
        repository.deleteById(id);
        return true;
    }
}
