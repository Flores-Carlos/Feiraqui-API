package br.com.api.feiraqui.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "feirante")
public class Feirante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_prestador", referencedColumnName = "id", nullable = false)
    private Prestador prestador;
}
