package web.controller;

import dto.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.MensajeriaService;
import service.impl.MensajeriaServiceImpl;

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
        Usuario usuario = new Usuario();
        mav.addObject("usuario", usuario);
        mav.addObject("paisList", mensajeriaService.getPaises());
        mav.addObject("comunidadList", mensajeriaService.getComunidades());
        return mav;
    }

    @RequestMapping(params = "accion=salida")
    public ModelAndView fin(@ModelAttribute Usuario usuario) {
        return new ModelAndView("salida", "usuario", usuario);//usuario es el que colocara en el formulario
    }

}
