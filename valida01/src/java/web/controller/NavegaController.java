package web.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavegaController {

    @RequestMapping(params = "accion=inicio")
    public ModelAndView inicio() {
        String msg = "Bienvenido a Spring";
        ModelAndView mav = new ModelAndView("destino", "mensaje", msg);
        return mav;
    }

    @RequestMapping(params = "accion=avisa")
    public ModelAndView avisa(HttpServletRequest request) {
        String msg = "Visitante: ";
        try {
            InetAddress ip = InetAddress.getLocalHost();
            msg += ip.getHostAddress();
        } catch (UnknownHostException ex) {
            msg = ex.getMessage();
        }
        ModelAndView mav = new ModelAndView("destino", "mensaje", msg);
        return mav;
    }

    @RequestMapping(params = "accion=fin")
    public ModelAndView fin() {
        String msg = "Hasta la vista...";
        ModelAndView mav = new ModelAndView("destino");
        mav.addObject("mensaje", msg);
        return mav;
    }
    
    @RequestMapping(params = "accion=propuesto")
    public ModelAndView propuesto() {
        String msg = "Hasta la vista...";
        ModelAndView mav = new ModelAndView("propuesto");
        mav.addObject("mensaje", msg);
        return mav;
    }

}
