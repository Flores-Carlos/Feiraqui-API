package br.com.api.feiraqui.model;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome_completo", length = 30, nullable = false)
    private String nome_completo;

    @Column(name = "email", length = 30, nullable = false)
    private String email;

    @Column(name = "rg_numero", length = 9, nullable = false)
    private long rg_numero;

    @Column(name = "rg_orgao_emissor", length = 6, nullable = false)
    private String rg_orgao_emissor;

    @Column(name = "cpf", length = 11, nullable = false)
    private long cpf;

    @Column(name = "senha", length = 30, nullable = false)
    private String senha;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id", nullable = false)
    private Endereco endereco;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_telefone", referencedColumnName = "id", nullable = false)
    private Telefone telefone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getRg_numero() {
        return rg_numero;
    }

    public void setRg_numero(long rg_numero) {
        this.rg_numero = rg_numero;
    }

    public String getRg_orgao_emissor() {
        return rg_orgao_emissor;
    }

    public void setRg_orgao_emissor(String rg_orgao_emissor) {
        this.rg_orgao_emissor = rg_orgao_emissor;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
}
