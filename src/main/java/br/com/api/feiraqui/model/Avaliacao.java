package br.com.api.feiraqui.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull(message = "A nota é obrigatória")
    @Column(name = "nota", nullable = false)
    private long nota;

    @Column(name = "comentario", columnDefinition = "TINYTEXT", nullable = true)
    private String comentario;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_fregues", referencedColumnName = "id", nullable = false)
    private Fregues fregues;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_prestador", referencedColumnName = "id", nullable = false)
    private Prestador prestador;
}
