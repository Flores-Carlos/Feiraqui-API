package br.com.api.feiraqui.repository;

import br.com.api.feiraqui.model.Prestador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPrestador extends JpaRepository<Prestador, Long> {

}
