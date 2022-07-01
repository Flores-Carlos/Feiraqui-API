package br.com.api.feiraqui.DAO;

import br.com.api.feiraqui.model.Prestador;
import org.springframework.data.repository.CrudRepository;

public interface IPrestador extends CrudRepository<Prestador, Long> {

}
