package br.com.api.feiraqui.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "O nome é obrigatório")
    @Column(name = "nome_completo", length = 30, nullable = false)
    private String nome_completo;

    @Email(message = "Insira um e-mail válido")
    @NotBlank(message = "O email é obrigatório")
    @Column(name = "email", length = 30, nullable = false)
    private String email;

    @NotNull(message = "O número do RG é obrigatório")
    @Column(name = "rg_numero", length = 9, nullable = false)
    private long rg_numero;

    @NotBlank(message = "O órgão emissor é obrigatório")
    @Column(name = "rg_orgao_emissor", length = 6, nullable = false)
    private String rg_orgao_emissor;

    @NotNull(message = "O CPF é obrigatório")
    @Column(name = "cpf", length = 11, nullable = false)
    private long cpf;

    @NotBlank(message = "A senha é obrigatória")
    @Column(name = "senha", length = 30, nullable = false)
    private String senha;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id", nullable = false)
    private Endereco endereco;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_telefone", referencedColumnName = "id", nullable = false)
    private Telefone telefone;
}
