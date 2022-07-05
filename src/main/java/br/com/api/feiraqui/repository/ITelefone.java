package br.com.api.feiraqui.repository;

import br.com.api.feiraqui.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITelefone extends JpaRepository<Telefone, Long> {

}
