package web.controller;

import dto.Data;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavegaController {

    @RequestMapping(params = "formulario")
    public ModelAndView inicio() {
        Data data = new Data();
        data.setValor(10);//pasandole el parametro
        //El destino es el jsp "data"
        ModelAndView mav = new ModelAndView("index", "data", data);//data es el objeto que se ha instanciado que deberia contener los datos
        return mav;
    }

    @RequestMapping(params = "duplica")
    public ModelAndView duplica(@ModelAttribute Data data) {
        
        String msg = "Valor : " + data.getValor();
        //El destino es el jsp "destino"
        ModelAndView mav = new ModelAndView("destino", "msg", msg);
        return mav;
    }
    
}
