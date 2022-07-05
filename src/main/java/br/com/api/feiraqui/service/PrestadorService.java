package br.com.api.feiraqui.service;

import br.com.api.feiraqui.model.Prestador;
import br.com.api.feiraqui.repository.IPrestador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestadorService {


    private IPrestador repository;

    public List<Prestador> listarPrestador() {
        List<Prestador> lista = repository.findAll();
        return lista;
    }

    public Prestador criarPrestador(Prestador prestador) {
        Prestador prestadorNovo = repository.save(prestador);
        return prestadorNovo;
    }

    public Prestador editarPrestador(Prestador prestador) {
        Prestador prestadorNovo = repository.save(prestador);
        return prestadorNovo;
    }

    public boolean excluirPrestador(long id) {
        repository.deleteById(id);
        return true;
    }
}
