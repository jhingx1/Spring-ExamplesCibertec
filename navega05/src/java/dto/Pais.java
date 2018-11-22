package dto;

public class Pais {

    private Integer paisId;
    //Se define como String normal por que solo se va a seleccionar uno en el formulario
    private String paisName;

    public Pais(Integer paisId, String paisName) {
        this.paisId = paisId;
        this.paisName = paisName;
    }

    public Integer getPaisId() {
        return paisId;
    }

    public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }

    public String getPaisName() {
        return paisName;
    }

    public void setPaisName(String paisName) {
        this.paisName = paisName;
    }
    
}
