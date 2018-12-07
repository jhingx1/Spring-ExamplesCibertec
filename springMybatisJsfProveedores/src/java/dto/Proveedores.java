package dto;

public class Proveedores {

    private Integer idproveedor;
    private Integer idcliente;
    private String razonsocial;
    private String direccion;
    private Integer iddistrito;
    private Integer iddepartamento;

    public Proveedores() {
    }

    public Integer getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getIddistrito() {
        return iddistrito;
    }

    public void setIddistrito(Integer iddistrito) {
        this.iddistrito = iddistrito;
    }

    public Integer getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(Integer iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

}

