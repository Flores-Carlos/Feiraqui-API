package br.com.api.feiraqui.model;

import javax.persistence.*;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nota", nullable = false)
    private int nota;

    @Column(name = "comentario", columnDefinition = "TINYTEXT", nullable = true)
    private String comentario;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_fregues", referencedColumnName = "id", nullable = false)
    private Fregues fregues;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_prestador", referencedColumnName = "id", nullable = false)
    private Prestador prestador;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Fregues getFregues() {
        return fregues;
    }

    public void setFregues(Fregues fregues) {
        this.fregues = fregues;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }
}
