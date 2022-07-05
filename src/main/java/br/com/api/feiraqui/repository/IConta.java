package br.com.api.feiraqui.repository;

import br.com.api.feiraqui.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConta extends JpaRepository<Conta, Long> {

}
