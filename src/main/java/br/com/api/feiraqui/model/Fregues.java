package br.com.api.feiraqui.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "fregues")
public class Fregues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    private Usuario usuario;
}
