package br.com.api.feiraqui.model;

import javax.persistence.*;

@Entity
@Table(name = "prestador")
public class Prestador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_telefone", nullable = false)
    private Telefone telefone;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_conta", referencedColumnName = "id", nullable = false)
    private Conta conta;
}
