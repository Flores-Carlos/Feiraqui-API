package br.com.api.feiraqui.model;

import javax.persistence.*;

@Entity
@Table(name = "barraca")
public class Barraca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_feirante", referencedColumnName = "id", nullable = false)
    private Feirante feirante;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Feirante getFeirante() {
        return feirante;
    }

    public void setFeirante(Feirante feirante) {
        this.feirante = feirante;
    }
}
