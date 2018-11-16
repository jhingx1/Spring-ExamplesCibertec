
package web.controller;
import dto.Calculadoras;
import dto.Alumnos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculadoraController {
    
    @RequestMapping(params = "ini")
    public ModelAndView inicio(){
        
        Calculadoras c = new Calculadoras();
        
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("index",c);
        
        return mav;
    }
    
    
    @RequestMapping(params = "suma")
    public ModelAndView suma(@ModelAttribute Calculadoras c){
        Double resultado = c.getValor1() + c.getValor2();
        String msg = resultado.toString();
        ModelAndView mav = new ModelAndView("resultado","msg",msg);        
        
        return mav;
    }
    
    @RequestMapping(params = "resta")
    public ModelAndView resta(@ModelAttribute Calculadoras c){
        Double resultado = c.getValor1() - c.getValor2();
        String msg = resultado.toString();
        ModelAndView mav = new ModelAndView("resultado","msg",msg);        
        
        return mav;
    }
    
    @RequestMapping(params = "multiplica")
    public ModelAndView multiplica(@ModelAttribute Calculadoras c){
        Double resultado = c.getValor1() * c.getValor2();
        String msg = resultado.toString();
        ModelAndView mav = new ModelAndView("resultado","msg",msg);        
        
        return mav;
    }
    
    @RequestMapping(params = "divide")
    public ModelAndView divide(@ModelAttribute Calculadoras c){
        Double resultado = c.getValor1() / c.getValor2();
        String msg = resultado.toString();
        ModelAndView mav = new ModelAndView("resultado","msg",msg);        
        
        return mav;
    }
   
}
