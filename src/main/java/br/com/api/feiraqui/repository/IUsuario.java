package br.com.api.feiraqui.repository;

import br.com.api.feiraqui.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuario extends JpaRepository<Usuario, Long> {

}
