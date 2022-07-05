package br.com.api.feiraqui.repository;

import br.com.api.feiraqui.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedido extends JpaRepository<Pedido, Long> {

}
