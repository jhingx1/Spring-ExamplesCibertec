package web.controller;

import domain.Alumnos;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.validator.AlumnosValidator;

@Controller
public class AlumnosController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView ingreso() {
        Alumnos a = new Alumnos();
        ModelAndView mav = new ModelAndView("index", "alumnos", a);//El jsp redirect apunta hacia aqui.
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView result(
            @ModelAttribute Alumnos a, BindingResult result) {
        AlumnosValidator validator = new AlumnosValidator();//Inicios de las validaciones.
        validator.validate(a, result);
        //Analizando la respuesta de la validacion
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView("index", "alumnos", a);
            return mav;
        } else {
            ModelAndView mav = new ModelAndView("result", "alumnos", a);
            return mav;
        }
    }

}
