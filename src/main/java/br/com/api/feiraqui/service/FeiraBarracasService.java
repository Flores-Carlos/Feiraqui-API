package br.com.api.feiraqui.service;

import br.com.api.feiraqui.model.FeiraBarracas;
import br.com.api.feiraqui.repository.IFeiraBarracas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeiraBarracasService {

    @Autowired
    private IFeiraBarracas repository;

    public List<FeiraBarracas> listarFeiraBarracas() {
        List<FeiraBarracas> lista = repository.findAll();
        return lista;
    }

    public FeiraBarracas criarFeiraBarracas(FeiraBarracas feiraBarracas) {
        FeiraBarracas feiraBarracasNovo = repository.save(feiraBarracas);
        return feiraBarracasNovo;
    }

    public FeiraBarracas editarFeiraBarracas(FeiraBarracas feiraBarracas) {
        FeiraBarracas feiraBarracasNovo = repository.save(feiraBarracas);
        return feiraBarracasNovo;
    }

    public boolean excluirFeiraBarracas(long id) {
        repository.deleteById(id);
        return true;
    }
}
