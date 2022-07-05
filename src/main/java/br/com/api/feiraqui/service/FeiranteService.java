package br.com.api.feiraqui.service;

import br.com.api.feiraqui.model.Feirante;
import br.com.api.feiraqui.repository.IFeirante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeiranteService {


    private IFeirante repository;

    public List<Feirante> listarFeirante() {
        List<Feirante> lista = repository.findAll();
        return lista;
    }

    public Feirante criarFeirante(Feirante feirante) {
        Feirante feiranteNovo = repository.save(feirante);
        return feiranteNovo;
    }

    public Feirante editarFeirante(Feirante feirante) {
        Feirante feiranteNovo = repository.save(feirante);
        return feiranteNovo;
    }

    public boolean excluirFeirante(long id) {
        repository.deleteById(id);
        return true;
    }
}
