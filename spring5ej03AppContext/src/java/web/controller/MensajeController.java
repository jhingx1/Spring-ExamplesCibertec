package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.ServiceTiempo;

@Controller
@RequestMapping("/mensaje")
public class MensajeController {
    
    @Autowired
    private ServiceTiempo serviceTiempo;
    
    @GetMapping(value = "/ini")
    public String inicio(Model model) {
        
        String now = serviceTiempo.hoy();
        model.addAttribute("ahora", now);
        
        return "inicio";
    }
}
