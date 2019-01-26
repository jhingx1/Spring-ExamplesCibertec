package web.validator;

import dto.Autores;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AutoresValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Autores.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Autores autores = (Autores) o;

        // validando atributo titulo
        String autor = autores.getAutor();
        if ((autor == null) || (autor.trim().length() == 0)) {
            errors.rejectValue("autor", "autor.required1");
        }
    }
}

