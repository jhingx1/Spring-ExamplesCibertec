package web.validator;

import domain.Ventas;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class VentasValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Ventas.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "cliente", "cliente.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "pago", "pago.required");
        ValidationUtils.rejectIfEmpty(
                errors, "cuello", "cuello.required");
        ValidationUtils.rejectIfEmpty(
                errors, "mangas", "mangas.required");
        ValidationUtils.rejectIfEmpty(
                errors, "color", "color.required");
        Ventas u = (Ventas) o;
        if (u.getTela().length == 0) {
            errors.rejectValue("tela", "tela.required");
        }
        
        
        Integer pago = u.getPago();
        if (pago == null) {
           // errors.rejectValue("cantidad", "cantidad.required1");
        } else if ((pago < 1)) {
            errors.rejectValue("pago", "pago.required2");
        }
    }
}
