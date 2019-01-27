package web.validator;

import domain.Frases;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FrasesValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Frases.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Frases frases = (Frases) o;
        
        // validando atributo idautor
        Integer idautor = frases.getIdautor();
        if(idautor == null) {
            errors.rejectValue("idautor", "idautor.required1");
        }

        // validando atributo titulo
        String frase = frases.getFrase();
        if ((frase == null) || (frase.trim().length() == 0)) {
            errors.rejectValue("frase", "frase.required1");

        } else if ((frase.trim().length() < 10)
                || (frase.trim().length() > 300)) {
            errors.rejectValue("frase", "frase.required2");
        }
    }
}

