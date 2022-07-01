package br.com.api.feiraqui.model;

import javax.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "total", nullable = false)
    private double total;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_fregues", referencedColumnName = "id", nullable = false)
    private Fregues fregues;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_entregador", referencedColumnName = "id", nullable = false)
    private Entregador entregador;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Fregues getFregues() {
        return fregues;
    }

    public void setFregues(Fregues fregues) {
        this.fregues = fregues;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }
}
