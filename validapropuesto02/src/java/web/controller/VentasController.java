package web.controller;

import domain.Ventas;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.validator.VentasValidator;

@Controller
public class VentasController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView ingreso() {
        Ventas u = new Ventas();
        ModelAndView mav = new ModelAndView("index", "ventas", u);
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView result(
            @ModelAttribute Ventas u, BindingResult result) {
        VentasValidator validator = new VentasValidator();
        validator.validate(u, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView("index", "ventas", u);
            return mav;
        } else {
            ModelAndView mav = new ModelAndView("result", "ventas", u);
            return mav;
        }
    }
}
