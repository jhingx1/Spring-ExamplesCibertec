

package web.controller;

import dto.Personas;
import dto.Alumnos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlumnoController {
    
    @RequestMapping(params = "ini")
    public ModelAndView inicio(){
        
        //Personas p = new Personas();
        Alumnos a = new Alumnos();
        
        //ModelAndView mav = new ModelAndView("alumno");
        //mav.addObject("personas", p);
        
        ModelAndView mav = new ModelAndView("alumno");
        mav.addObject("alumno",a);
        
        return mav;
    }
    
    @RequestMapping(params = "fin")
    public ModelAndView mensaje(@ModelAttribute Alumnos a){
        Double promedio = 0.0;
        
        promedio = (a.getNota1().doubleValue() + a.getNota2().doubleValue() + a.getNota3().doubleValue())/3;
        
        String msg = "El alumno "+a.getNombre() + " tiene un promedio de " + promedio;
        
        //ModelAndView mav = new ModelAndView("bienvenida");        
        ModelAndView mav = new ModelAndView("repalumno","msg",msg);        
        
        return mav;
    }
    
}
