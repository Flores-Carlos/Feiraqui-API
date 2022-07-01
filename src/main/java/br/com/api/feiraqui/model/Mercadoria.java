package br.com.api.feiraqui.model;

import javax.persistence.*;

@Entity
@Table(name = "mercadoria")
public class Mercadoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "descricao", nullable = true)
    private String descricao;

    @Column(name = "preco", nullable = false)
    private double preco;

    @Column(name = "unidade_medida", nullable = false)
    private String unidade_medida;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_barraca", referencedColumnName = "id", nullable = false)
    private Barraca barraca;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getUnidade_medida() {
        return unidade_medida;
    }

    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    public Barraca getBarraca() {
        return barraca;
    }

    public void setBarraca(Barraca barraca) {
        this.barraca = barraca;
    }
}
