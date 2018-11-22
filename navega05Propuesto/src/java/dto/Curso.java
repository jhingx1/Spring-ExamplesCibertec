package dto;
public class Curso {
    
    private Integer cursoId;
    private String curso;

    public Curso(Integer cursoId, String curso) {
        this.cursoId = cursoId;
        this.curso = curso;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}
