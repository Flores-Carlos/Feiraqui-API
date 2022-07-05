package br.com.api.feiraqui.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "feira")
public class Feira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome", length = 30, nullable = true)
    private String nome;

    @NotBlank(message = "A categoria é obrigatória")
    @Column(name = "categoria", nullable = false)
    private String categoria;

    @NotBlank(message = "O dia da semana é obrigatório")
    @Column(name = "dia", nullable = false)
    private String dia;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id", nullable = false)
    private Endereco endereco;
}
