package br.com.api.feiraqui.repository;

import br.com.api.feiraqui.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEndereco extends JpaRepository<Endereco, Long> {

}
