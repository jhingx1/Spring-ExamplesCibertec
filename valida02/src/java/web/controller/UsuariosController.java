package web.controller;

import domain.Usuarios;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.validator.UsuariosValidator;

@Controller
public class UsuariosController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView ingreso() {
        Usuarios u = new Usuarios();
        ModelAndView mav = new ModelAndView("index", "usuarios", u);
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView result(
            @ModelAttribute Usuarios u, BindingResult result) {
        UsuariosValidator validator = new UsuariosValidator();
        validator.validate(u, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView("index", "usuarios", u);
            return mav;
        } else {
            ModelAndView mav = new ModelAndView("result", "usuarios", u);
            return mav;
        }
    }

}
