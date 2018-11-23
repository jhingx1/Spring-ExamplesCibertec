package web.validator;

import domain.Usuarios;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UsuariosValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Usuarios.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "nombre", "nombre.required");
        ValidationUtils.rejectIfEmpty(
                errors, "genero", "genero.required");
        ValidationUtils.rejectIfEmpty(
                errors, "pais", "pais.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "acerca", "acerca.required");
        Usuarios u = (Usuarios) o;
        if (u.getComunidad().length == 0) {
            errors.rejectValue("comunidad", "comunidad.required");
        }
    }

}
