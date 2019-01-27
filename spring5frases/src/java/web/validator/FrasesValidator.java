package web.validator;

import model.Frases;
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
        Integer idautor = frases.getAutores().getIdautor();
        if(idautor == null) {
            errors.rejectValue("autores.idautor", "", "idautor requerido");
        }

        // validando atributo titulo
        String frase = frases.getFrase();
        if ((frase == null) || (frase.trim().length() == 0)) {
            errors.rejectValue("frase", "", "frase requerida");

        } else if ((frase.trim().length() < 10)
                || (frase.trim().length() > 300)) {
            errors.rejectValue("frase", "", "frase entre [10, 200] caracteres");
        }
    }
}

