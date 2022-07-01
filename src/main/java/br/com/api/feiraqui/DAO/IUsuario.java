package br.com.api.feiraqui.DAO;

import br.com.api.feiraqui.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuario extends CrudRepository<Usuario, Long> {

}
