package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mensaje")
public class MensajeController {
    
    @GetMapping(value = "/ini")
    public String inicio(Model model) {
        return "inicio";
    }

    @GetMapping(value = "/get")
    public String metodoGet(Model model) {
        
        model.addAttribute("msg", "Ejemplo de método GET");
        return "mget";
    }

    @PostMapping(value = "/post")
    public String metodoPost(Model model) {
        
        model.addAttribute("msg", "Ejemplo de método POST");
        return "mpost";
    }
}
