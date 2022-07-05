package br.com.api.feiraqui.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "O nome completo é obrigatório")
    @Column(name = "nome_completo", length = 30, nullable = false)
    private String nome_completo;

    @NotBlank(message = "O banco é obrigatório")
    @Column(name = "banco", length = 30, nullable = false)
    private String banco;

    @NotNull(message = "A agência é obrigatória")
    @Column(name = "agencia", length = 4, nullable = false)
    private long agencia;

    @NotNull(message = "O número é obrigatório")
    @Column(name = "numero", nullable = false)
    private long numero;

    @NotNull(message = "O tipo é obrigatório")
    @Column(name = "tipo", length = 15, nullable = false)
    private String tipo;
}
