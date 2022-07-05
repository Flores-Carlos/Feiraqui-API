package br.com.api.feiraqui.service;

import br.com.api.feiraqui.model.Mercadoria;
import br.com.api.feiraqui.repository.IMercadoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MercadoriaService {


    private IMercadoria repository;

    public List<Mercadoria> listarMercadoria() {
        List<Mercadoria> lista = repository.findAll();
        return lista;
    }

    public Mercadoria criarMercadoria(Mercadoria pmercadoria) {
        Mercadoria pmercadoriaNovo = repository.save(pmercadoria);
        return pmercadoriaNovo;
    }

    public Mercadoria editarMercadoria(Mercadoria pmercadoria) {
        Mercadoria pmercadoriaNovo = repository.save(pmercadoria);
        return pmercadoriaNovo;
    }

    public boolean excluirMercadoria(long id) {
        repository.deleteById(id);
        return true;
    }
}
