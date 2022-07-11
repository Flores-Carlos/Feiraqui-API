package br.com.api.feiraqui.service;

import br.com.api.feiraqui.model.Endereco;
import br.com.api.feiraqui.repository.IEndereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private IEndereco repository;

    public List<Endereco> listarEndereco() {
        List<Endereco> lista = repository.findAll();
        return lista;
    }

    public Endereco criarEndereco(Endereco endereco) {
        Endereco enderecoNovo = repository.save(endereco);
        return enderecoNovo;
    }

    public Endereco editarEndereco(Endereco endereco) {
        Endereco enderecoNovo = repository.save(endereco);
        return enderecoNovo;
    }

    public boolean excluirEndereco(long id) {
        repository.deleteById(id);
        return true;
    }
}
