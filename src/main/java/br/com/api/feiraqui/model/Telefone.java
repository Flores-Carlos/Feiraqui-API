package br.com.api.feiraqui.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "O prefixo é obrigatório")
    @Column(name = "prefixo", length = 4, nullable = false)
    private long prefixo;

    @NotBlank(message = "O DDD é obrigatório")
    @Column(name = "ddd", length = 2, nullable = false)
    private long ddd;

    @NotBlank(message = "O número é obrigatório")
    @Column(name = "numero", nullable = false)
    private long numero;
}
