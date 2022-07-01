package br.com.api.feiraqui.model;

import javax.persistence.*;

@Entity
@Table(name = "feirante")
public class Feirante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_prestador", referencedColumnName = "id", nullable = false)
    private Prestador prestador;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }
}
