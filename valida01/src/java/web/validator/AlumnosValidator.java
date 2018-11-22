package web.validator;

import domain.Alumnos;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AlumnosValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Alumnos.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Alumnos a = (Alumnos) o;
// validando nombre
        String nombre = a.getNombre();
        if (nombre == null) {
            //Uso del archivo properties para los mensajes de validaciones.
            errors.rejectValue("nombre", "nombre.required1");
        } else if (nombre.trim().length() == 0) {
            errors.rejectValue("nombre", "nombre.required1");
        } else if ((nombre.trim().length() < 3)
                || (nombre.trim().length() > 50)) {
            errors.rejectValue("nombre", "nombre.required2");
        }
// validando nota
        Integer nota = a.getNota();
        if (nota == null) {
            errors.rejectValue("nota", "nota.required1");
        } else if ((nota < 0) || (nota > 20)) {
            errors.rejectValue("nota", "nota.required2");
        }
    }

}
