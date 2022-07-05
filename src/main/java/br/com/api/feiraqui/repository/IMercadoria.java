package br.com.api.feiraqui.repository;

import br.com.api.feiraqui.model.Mercadoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMercadoria extends JpaRepository<Mercadoria, Long> {

}
