package br.com.api.feiraqui.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "prefixo", length = 4, nullable = false)
    private long prefixo;

    @NotNull(message = "O DDD é obrigatório")
    @Column(name = "ddd", length = 2, nullable = false)
    private long ddd;

    @NotNull(message = "O número é obrigatório")
    @Column(name = "numero", nullable = false)
    private long numero;
}
