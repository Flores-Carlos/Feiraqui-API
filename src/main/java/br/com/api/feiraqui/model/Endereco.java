package br.com.api.feiraqui.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "O CEP é obrigatório")
    @Column(name = "cep", length = 8, nullable = false)
    private String cep;

    @NotBlank(message = "A rua é obrigatória")
    @Column(name = "rua", length = 30, nullable = false)
    private String rua;

    @NotBlank(message = "O bairro é obrigatório")
    @Column(name = "bairro", length = 30, nullable = false)
    private String bairro;

    @NotBlank(message = "O bairro é obrigatório")
    @Column(name = "cidade", length = 30, nullable = false)
    private String cidade;

    @NotBlank(message = "A Unidade Federal é obrigatória")
    @Column(name = "uf", length = 2, nullable = false)
    private String uf;

    @Column(name = "numero", nullable = true)
    private String numero;

    @Column(name = "complemento", columnDefinition = "TINYTEXT", nullable = true)
    private String complemento;
}
