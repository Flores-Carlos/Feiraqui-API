package br.com.api.feiraqui.DAO;

import br.com.api.feiraqui.model.Mercadoria;
import org.springframework.data.repository.CrudRepository;

public interface IMercadoria extends CrudRepository<Mercadoria, Long> {

}
