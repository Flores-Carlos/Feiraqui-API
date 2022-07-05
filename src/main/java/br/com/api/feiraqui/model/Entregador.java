package br.com.api.feiraqui.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "entregador")
public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_prestador", referencedColumnName = "id", nullable = false)
    private Prestador prestador;
}
