package web.controller;

import dto.Alumnos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.MaximoService;
import service.MensajeriaService;
import service.impl.MensajeriaServiceImpl;

@Controller
public class NotasController {

    //IoC Inversion de Control
    private MensajeriaService mensajeriaService;
    private MaximoService maximoService;

    //Este es el metodo que esta definido en el applicationContest
    public void setMensajeriaService(MensajeriaServiceImpl mensajeriaService) {
        this.mensajeriaService = mensajeriaService;
    }

    public void setMaximoService(MaximoService maximoService) {
        this.maximoService = maximoService;
    }
    
    /*
    public void setXyz(MensajeriaServiceImpl mensajeriaService) {
        this.mensajeriaService = mensajeriaService;
    }
    */
    //Notar que mesajeriaService no se ha instanciado el spring 
    
    //Ioc  - Fin

    @RequestMapping(params = "ingreso")
    public ModelAndView ingreso() {
        Alumnos a = new Alumnos();
        a.setNota1(14);
        a.setNota2(14);
        a.setNota3(14);
        ModelAndView mav = new ModelAndView("index", "alumno", a);
        return mav;
    }

    @RequestMapping(params = "salida")
    public ModelAndView ingreso(@ModelAttribute Alumnos a) {
        //Invocando al servicio
        String msg1 = mensajeriaService.mensaje(a);
        String msg2 = maximoService.maxima(a);
        
        ModelAndView  mav = new ModelAndView("result"); 
        mav.addObject("msg1",msg1);
        mav.addObject("msg2",msg2);
        
        /*
        String msg = maximoService.maxima(a);
        ModelAndView mav = new ModelAndView("result", "msg", msg);
        */
        
        return mav;
    }

}
