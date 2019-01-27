package domain;

public class Autores {

    private Integer idautor;
    private String autor;

    public Autores() {
    }

    public Autores(Integer idautor, String autor) {
        this.idautor = idautor;
        this.autor = autor;
    }

    public Integer getIdautor() {
        return idautor;
    }

    public void setIdautor(Integer idautor) {
        this.idautor = idautor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
