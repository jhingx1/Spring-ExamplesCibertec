package service.impl;

import dto.Curso;
import dto.Local;
import dto.Pago;
import java.util.ArrayList;
import java.util.List;
import service.MensajeriaService;

public class MensajeriaServiceImpl implements MensajeriaService {

  //----------

    @Override
    public List<Curso> getCursos() {
        List cursosList = new ArrayList();
        cursosList.add(new Curso(1, "Java F"));
        cursosList.add(new Curso(2, "PHP"));
        cursosList.add(new Curso(3, "C#"));
        return cursosList;
    }

    @Override
    public List<Local> getLocales() {
        List localList = new ArrayList();
        localList.add(new Local(1, "Surco"));
        localList.add(new Local(2, "Lima"));
        localList.add(new Local(3, "Cusco"));
        return localList;
    }

    @Override
    public List<Pago> getPagos() {
        List pagosList = new ArrayList();
        pagosList.add(new Pago(1, "Tarjeta"));
        pagosList.add(new Pago(2, "Efectivo"));
        pagosList.add(new Pago(3, "Plazos"));
        return pagosList;
    }

}
