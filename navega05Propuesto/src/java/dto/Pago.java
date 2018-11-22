package dto;
public class Pago {
    
    private Integer pagoId;
    private String pago;

    public Pago(Integer pagoId, String pago) {
        this.pagoId = pagoId;
        this.pago = pago;
    }

    public Integer getPagoId() {
        return pagoId;
    }

    public void setPagoId(Integer pagoId) {
        this.pagoId = pagoId;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }
    
}
