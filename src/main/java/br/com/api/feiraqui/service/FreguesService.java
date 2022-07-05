package br.com.api.feiraqui.service;

import br.com.api.feiraqui.model.Fregues;
import br.com.api.feiraqui.repository.IFregues;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreguesService {


    private IFregues repository;

    public List<Fregues> listarFregues() {
        List<Fregues> lista = repository.findAll();
        return lista;
    }

    public Fregues criarFregues(Fregues fregues) {
        Fregues freguesNovo = repository.save(fregues);
        return freguesNovo;
    }

    public Fregues editarFregues(Fregues fregues) {
        Fregues freguesNovo = repository.save(fregues);
        return freguesNovo;
    }

    public boolean excluirFregues(long id) {
        repository.deleteById(id);
        return true;
    }
}
