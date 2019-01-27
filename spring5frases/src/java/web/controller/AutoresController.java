package web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.Autores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import parainfo.convert.DeString;
import services.ServicesAutores;
import web.validator.AutoresValidator;

@Controller
@RequestMapping("/autores")
public class AutoresController {

    @Autowired
    private ServicesAutores servicesAutores;

    @GetMapping(value = "/qry")
    public ModelAndView qry(Model model) {
        List<Autores> list = servicesAutores.autoresQry();

        ModelAndView mav = new ModelAndView("autores", "list", list);
        return mav;
    }

    @GetMapping(value = "/ins")
    public ModelAndView ins(Model model) {
        Autores autores = new Autores();
        
        ModelAndView mav = new ModelAndView("autoresIns", "autores", autores);
        return mav;
    }

    @PostMapping(value = "/insdb")
    public ModelAndView ins(@ModelAttribute Autores autores, BindingResult bindingResult) {

        AutoresValidator validator = new AutoresValidator();
        validator.validate(autores, bindingResult);

        ModelAndView mav = new ModelAndView("autoresIns");

        if (!bindingResult.hasErrors()) { // si no hay errores en envio del cliente

            String result = servicesAutores.autoresInsUpd(autores);

            if (result == null) { // si autor no es repetido
                mav = new ModelAndView("redirect:qry");

            } else { // autor es repetido
                mav.addObject("autores", autores);
                bindingResult.addError(new ObjectError("msg", result));
            }

        } else { // si hay errores de envio del cliente
            mav.addObject("autores", autores);
        }

        return mav;
    }

    @GetMapping(value = "/del")
    public ModelAndView del(HttpServletRequest request, Model model) {
        List<Integer> list = DeString.ids(request.getParameter("ids"));

        String result = servicesAutores.autoresDel(list);

        ModelAndView mav = qry(model);
        if (result != null) {
            mav.addObject("msg", result);
        }

        return mav;
    }

    @GetMapping(value = "/get")
    public ModelAndView get(HttpServletRequest request, Model model) {
        Integer idautor = DeString.aInteger(request.getParameter("idautor"));

        Autores autores = servicesAutores.autoresGet(idautor);

        ModelAndView mav = qry(model);
        if (autores != null) {
            mav = new ModelAndView("autoresUpd");
            mav.addObject(autores);

        } else {
            mav.addObject("msg", "Autor de ID: " + idautor + ", no registrado");
        }

        return mav;
    }
    
    @PostMapping(value = "/upd")
    public ModelAndView upd(@ModelAttribute Autores autores, BindingResult bindingResult) {

        AutoresValidator validator = new AutoresValidator();
        validator.validate(autores, bindingResult);

        ModelAndView mav = new ModelAndView("autoresUpd");

        if (!bindingResult.hasErrors()) { // si no hay errores en envio del cliente

            String result = servicesAutores.autoresInsUpd(autores);

            if (result == null) { // si autor no es repetido
                mav = new ModelAndView("redirect:qry");

            } else { // autor es repetido
                mav.addObject("autores", autores);
                bindingResult.addError(new ObjectError("msg", result));
            }

        } else { // si hay errores de envio del cliente
            mav.addObject("autores", autores);
        }

        return mav;
    }
}
