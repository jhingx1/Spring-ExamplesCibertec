package service;

import dto.Comunidad;
import dto.Pais;
import java.util.List;

public interface MensajeriaService {

    public List<Pais> getPaises();
    public List<Comunidad> getComunidades();

}
