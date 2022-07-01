package br.com.api.feiraqui.DAO;

import br.com.api.feiraqui.model.Conta;
import org.springframework.data.repository.CrudRepository;

public interface IConta extends CrudRepository<Conta, Long> {

}
