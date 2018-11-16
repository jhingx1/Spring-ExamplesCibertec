

package web.controller;

import dto.Personas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SaludoController {
    
    @RequestMapping(params = "ini")
    public ModelAndView inicio(){
        
        Personas p = new Personas();
        
        ModelAndView mav = new ModelAndView("pedido");
        mav.addObject("personas", p);
        
        return mav;
    }
    
    @RequestMapping(params = "fin")
    public ModelAndView mensaje(@ModelAttribute Personas s){
        
        String msg = s.getNombre() + " tiene " + s.getEdad() + " años";
        
        //ModelAndView mav = new ModelAndView("bienvenida");        
        ModelAndView mav = new ModelAndView("bienvenida","msg",msg);        
        
        return mav;
    }
    
}
