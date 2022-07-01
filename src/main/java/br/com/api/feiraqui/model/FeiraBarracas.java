package br.com.api.feiraqui.model;

import javax.persistence.*;

@Entity
@Table(name = "feira_barracas")
public class FeiraBarracas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_feira", referencedColumnName = "id", nullable = false)
    private Feira feira;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_barraca", referencedColumnName = "id", nullable = false)
    private Barraca barraca;

    @Column(name = "largura", nullable = true)
    private double largura;

    @Column(name = "profundidade", nullable = true)
    private Double profundidade;

    @Column(name = "subprefeitura", length = 2, nullable = true)
    private String subprefeitura;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Feira getFeira() {
        return feira;
    }

    public void setFeira(Feira feira) {
        this.feira = feira;
    }

    public Barraca getBarraca() {
        return barraca;
    }

    public void setBarraca(Barraca barraca) {
        this.barraca = barraca;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public Double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(Double profundidade) {
        this.profundidade = profundidade;
    }

    public String getSubprefeitura() {
        return subprefeitura;
    }

    public void setSubprefeitura(String subprefeitura) {
        this.subprefeitura = subprefeitura;
    }
}
