package model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "autores")
public class Autores implements Serializable {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrementable en MySQL
    private Integer idautor;

    private String autor;

    //@OneToMany(mappedBy = "autores", fetch = FetchType.EAGER) // enlazado al atributo autores (frases) y EAGER significa que cada que pido un autor este vendra con sus frases
    @OneToMany(mappedBy = "autores")
    private Set<Frases> frases = new LinkedHashSet<>();

    public Autores() {
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getIdautor() {
        return idautor;
    }

    public void setIdautor(Integer idautor) {
        this.idautor = idautor;
    }

    public Set<Frases> getFrases() {
        return frases;
    }

    public void setFrases(Set<Frases> frases) {
        this.frases = frases;
    }

}
