package br.com.api.feiraqui.repository;

import br.com.api.feiraqui.model.Feira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFeira extends JpaRepository<Feira, Long> {

}
