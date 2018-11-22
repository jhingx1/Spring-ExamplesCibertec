package dto;

public class Comunidad {

    private String comunidadId;
    private String comunidadName;

    public Comunidad(String comunidadId, String comunidadName) {
        this.comunidadId = comunidadId;
        this.comunidadName = comunidadName;
    }

    public String getComunidadId() {
        return comunidadId;
    }

    public void setComunidadId(String comunidadId) {
        this.comunidadId = comunidadId;
    }

    public String getComunidadName() {
        return comunidadName;
    }

    public void setComunidadName(String comunidadName) {
        this.comunidadName = comunidadName;
    }
    
}
