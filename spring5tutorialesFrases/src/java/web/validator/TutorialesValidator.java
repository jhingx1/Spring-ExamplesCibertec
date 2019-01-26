package web.validator;

import dto.Tutoriales;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TutorialesValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Tutoriales.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Tutoriales tutoriales = (Tutoriales) o;

        // validando atributo titulo
        String titulo = tutoriales.getTitulo();
        if ((titulo == null) || (titulo.trim().length() == 0)) {
            errors.rejectValue("titulo", "titulo.required1");

        } else if ((titulo.trim().length() < 3)
                || (titulo.trim().length() > 100)) {
            errors.rejectValue("titulo", "titulo.required2");
        }

        // validando atributo tipo
        String tipo = tutoriales.getTipo();
        if ((tipo == null)
                || ((tipo.compareTo("Separata") != 0)
                && (tipo.compareTo("Video") != 0))) {
            errors.rejectValue("tipo", "tipo.required1");
        }

        // validando atributo precio
        Double precio = tutoriales.getPrecio();
        if (precio == null) {
            errors.rejectValue("precio", "precio.required1");

        } else if (precio <= 0) {
            errors.rejectValue("precio", "precio.required2");
        }
    }
}


