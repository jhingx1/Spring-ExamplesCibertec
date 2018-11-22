package service.impl;

import dto.Alumnos;
import java.util.Locale;
import service.MensajeriaService;

public class MensajeriaServiceImpl implements MensajeriaService {

    @Override
    public String mensaje(Alumnos alumnos) {
        String msg = alumnos.getNombre()
                + " tiene promedio " + String.format(Locale.US, "%1.2f",
                        (alumnos.getNota1()
                        + alumnos.getNota2()
                        + alumnos.getNota3()) / 3D);
        return msg;
    }

}
