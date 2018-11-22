package web.controller;

import dto.Alumno;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.MensajeriaService;
import service.impl.MensajeriaServiceImpl;

@Controller
public class FormularioController {

    // IoC
    private MensajeriaService mensajeriaService;

    public void setMensajeriaService(MensajeriaServiceImpl mensajeriaService) {
        this.mensajeriaService = mensajeriaService;
    }
// --

    @RequestMapping(params = "accion=entrada")
    public ModelAndView entrada() {
        ModelAndView mav = new ModelAndView("entrada");
        
        Alumno alumno = new Alumno();
        mav.addObject("alumno", alumno);
        mav.addObject("cursosList",mensajeriaService.getCursos());
        mav.addObject("localList",mensajeriaService.getLocales());
        mav.addObject("pagosList",mensajeriaService.getPagos());
                        
        return mav;
    }

    @RequestMapping(params = "accion=salida")
    public ModelAndView fin(@ModelAttribute Alumno alumno) {
        return new ModelAndView("salida", "alumno", alumno);
    }

}
