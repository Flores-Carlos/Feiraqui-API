package br.com.api.feiraqui.repository;

import br.com.api.feiraqui.model.Feirante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFeirante extends JpaRepository<Feirante, Long> {

}
