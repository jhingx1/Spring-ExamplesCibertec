package service;

import dto.Pago;
import dto.Curso;
import dto.Local;
import java.util.List;

public interface MensajeriaService {

    public List<Curso> getCursos();
    public List<Local> getLocales();
    public List<Pago> getPagos();

}
