package br.com.api.feiraqui.DAO;

import br.com.api.feiraqui.model.Feira;
import org.springframework.data.repository.CrudRepository;

public interface IFeira extends CrudRepository<Feira, Long> {

}
