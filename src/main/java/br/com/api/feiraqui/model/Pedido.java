package br.com.api.feiraqui.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "total", nullable = false)
    private double total;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_fregues", referencedColumnName = "id", nullable = false)
    private Fregues fregues;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_entregador", referencedColumnName = "id", nullable = false)
    private Entregador entregador;
}
