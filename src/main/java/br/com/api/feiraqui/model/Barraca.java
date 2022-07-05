package br.com.api.feiraqui.model;

import lombok.Data;

import javax.persistence.*;

@Data
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
}
