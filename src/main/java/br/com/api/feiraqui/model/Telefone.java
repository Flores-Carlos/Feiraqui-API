package br.com.api.feiraqui.model;

import javax.persistence.*;

@Entity
@Table(name = "telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "prefixo", length = 4, nullable = false)
    private long prefixo;

    @Column(name = "ddd", length = 2, nullable = false)
    private long ddd;

    @Column(name = "numero", nullable = false)
    private long numero;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(long prefixo) {
        this.prefixo = prefixo;
    }

    public long getDdd() {
        return ddd;
    }

    public void setDdd(long ddd) {
        this.ddd = ddd;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }
}
