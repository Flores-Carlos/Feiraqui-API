package br.com.api.feiraqui.DAO;

import br.com.api.feiraqui.model.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface IPedido extends CrudRepository<Pedido, Long> {

}
