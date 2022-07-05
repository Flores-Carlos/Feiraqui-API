package br.com.api.feiraqui.model;

import javax.persistence.*;

@Entity
@Table(name = "fregues")
public class Fregues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_telefone", referencedColumnName = "id", nullable = false)
    private Telefone telefone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
}
