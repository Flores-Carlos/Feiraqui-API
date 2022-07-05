package br.com.api.feiraqui.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "feira_barracas")
public class FeiraBarracas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_feira", referencedColumnName = "id", nullable = false)
    private Feira feira;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_barraca", referencedColumnName = "id", nullable = false)
    private Barraca barraca;

    @Column(name = "largura", nullable = true)
    private double largura;

    @Column(name = "profundidade", nullable = true)
    private double profundidade;

    @Column(name = "subprefeitura", length = 2, nullable = true)
    private String subprefeitura;
}
