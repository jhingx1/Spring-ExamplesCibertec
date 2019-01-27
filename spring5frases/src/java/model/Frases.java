package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "frases")
public class Frases implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idfrase;

    @ManyToOne
    @JoinColumn(name = "idautor")
    private Autores autores;

    private String frase;

    public Frases() {
    }

    public Integer getIdfrase() {
        return idfrase;
    }

    public void setIdfrase(Integer idfrase) {
        this.idfrase = idfrase;
    }

    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

}
