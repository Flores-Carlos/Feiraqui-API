package br.com.api.feiraqui.service;

import br.com.api.feiraqui.model.Avaliacao;
import br.com.api.feiraqui.repository.IAvaliacao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {


    private IAvaliacao repository;

    public List<Avaliacao> listarAvaliacao() {
        List<Avaliacao> lista = repository.findAll();
        return lista;
    }

    public Avaliacao criarAvaliacao(Avaliacao avaliacao) {
        Avaliacao avaliacaoNovo = repository.save(avaliacao);
        return avaliacaoNovo;
    }

    public Avaliacao editarAvaliacao(Avaliacao avaliacao) {
        Avaliacao avaliacaoNovo = repository.save(avaliacao);
        return avaliacaoNovo;
    }

    public boolean excluirAvaliacao(long id) {
        repository.deleteById(id);
        return true;
    }
}
