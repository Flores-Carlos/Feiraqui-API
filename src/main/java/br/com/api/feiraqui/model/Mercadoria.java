package br.com.api.feiraqui.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "mercadoria")
public class Mercadoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "O nome é obrigatório")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotBlank(message = "A categoria é obrigatória")
    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "descricao", nullable = true)
    private String descricao;

    @NotNull(message = "O preço é obrigatório")
    @Column(name = "preco", nullable = false)
    private double preco;

    @NotBlank(message = "A unidade de medida é obrigatória")
    @Column(name = "unidade_medida", nullable = false)
    private String unidade_medida;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_barraca", referencedColumnName = "id", nullable = false)
    private Barraca barraca;
}
