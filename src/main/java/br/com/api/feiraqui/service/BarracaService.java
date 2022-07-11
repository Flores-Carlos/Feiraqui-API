package br.com.api.feiraqui.service;

import br.com.api.feiraqui.model.Barraca;
import br.com.api.feiraqui.repository.IBarraca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarracaService {

    @Autowired
    private IBarraca repository;

    public List<Barraca> listarBarraca() {
        List<Barraca> lista = repository.findAll();
        return lista;
    }

    public Barraca criarBarraca(Barraca barraca) {
        Barraca barracaNovo = repository.save(barraca);
        return barracaNovo;
    }

    public Barraca editarBarraca(Barraca barraca) {
        Barraca barracaNovo = repository.save(barraca);
        return barracaNovo;
    }

    public boolean excluirBarraca(long id) {
        repository.deleteById(id);
        return true;
    }
}
