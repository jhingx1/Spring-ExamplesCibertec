package web.controller;

import dto.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormularioController {

    public FormularioController() {
    }

    @RequestMapping(params = "accion=ING")
    public ModelAndView ingreso() {
        Data data = new Data();

        ModelAndView mav = new ModelAndView("index", "data", data);
        return mav;
    }

    @RequestMapping(params = "accion=SAL")
    public ModelAndView salida(@ModelAttribute Data data) {
        String msg = "Bienvenido " + data.getNombres()
                + " " + data.getApellidos() + " a Spring";

        ModelAndView mav = new ModelAndView("result", "msg", msg);
        return mav;
    }
}
