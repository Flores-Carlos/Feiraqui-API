package br.com.api.feiraqui.repository;

import br.com.api.feiraqui.model.FeiraBarracas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFeiraBarracas extends JpaRepository<FeiraBarracas, Long> {

}
