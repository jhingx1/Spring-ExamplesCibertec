package service.impl;

import dto.Alumnos;
import dto.Comunidad;
import dto.Pais;
import java.util.ArrayList;
import java.util.List;
import service.MensajeriaService;

public class MensajeriaServiceImpl implements MensajeriaService {

    @Override
    public List<Pais> getPaises() {
        List paisList = new ArrayList();
        paisList.add(new Pais(1, "Perú"));
        paisList.add(new Pais(2, "Bolivia"));
        paisList.add(new Pais(3, "Ecuador"));
        return paisList;
    }

    @Override
    public List<Comunidad> getComunidades() {
        List comunidadList = new ArrayList();
        comunidadList.add(new Comunidad("Spring", "Spring"));
        comunidadList.add(new Comunidad("Hibernate", "Hibernate"));
        comunidadList.add(new Comunidad("Struts", "Struts"));
        return comunidadList;
    }

}
