package br.com.api.feiraqui.service;

import br.com.api.feiraqui.model.Feira;
import br.com.api.feiraqui.repository.IFeira;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeiraService {


    private IFeira repository;

    public List<Feira> listarFeira() {
        List<Feira> lista = repository.findAll();
        return lista;
    }

    public Feira criarFeira(Feira feira) {
        Feira feiraNovo = repository.save(feira);
        return feiraNovo;
    }

    public Feira editarFeira(Feira feira) {
        Feira feiraNovo = repository.save(feira);
        return feiraNovo;
    }

    public boolean excluirFeira(long id) {
        repository.deleteById(id);
        return true;
    }
}
