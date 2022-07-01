package br.com.api.feiraqui.model;

import javax.persistence.*;

@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome_completo", length = 30, nullable = false)
    private String nome_completo;

    @Column(name = "banco", length = 30, nullable = false)
    private String banco;

    @Column(name = "agencia", length = 4, nullable = false)
    private Long agencia;

    @Column(name = "numero", nullable = false)
    private Long numero;

    @Column(name = "tipo", length = 15, nullable = false)
    private String tipo;

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

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Long getAgencia() {
        return agencia;
    }

    public void setAgencia(Long agencia) {
        this.agencia = agencia;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
}
