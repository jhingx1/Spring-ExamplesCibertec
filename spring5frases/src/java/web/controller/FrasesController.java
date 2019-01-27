package web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.Autores;
import model.Frases;
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
import services.ServicesFrases;
import web.validator.FrasesValidator;

@Controller
@RequestMapping("/frases")
public class FrasesController {

    @Autowired
    private ServicesFrases servicesFrases;
    @Autowired
    private ServicesAutores servicesAutores;

    @GetMapping(value = "/qry")
    public ModelAndView qry(Model model) {
        List<Frases> list = servicesFrases.frasesQry();

        ModelAndView mav = new ModelAndView("frases", "list", list);
        return mav;
    }

    @GetMapping(value = "/ins")
    public ModelAndView ins() {
        Autores autores = new Autores();
        Frases frases = new Frases();
        frases.setAutores(autores);

        ModelAndView mav = new ModelAndView("frasesIns", "frases", frases);

        List<Autores> list = servicesAutores.autoresCbo();
        mav.addObject("list", list);

        return mav;
    }

    @PostMapping(value = "/insdb")
    public ModelAndView ins(@ModelAttribute Frases frases, BindingResult bindingResult) {
        FrasesValidator validator = new FrasesValidator();
        validator.validate(frases, bindingResult);

        ModelAndView mav = new ModelAndView("frasesIns");

        boolean ok = true;
        if (!bindingResult.hasErrors()) { // si no hay errores en envio del cliente
            String result = servicesFrases.frasesInsUpd(frases);

            if (result != null) { // si autor no es repetido
                bindingResult.addError(new ObjectError("msg", result));
                ok = false;
            }
        } else { // si hay errores de envio del cliente
            ok = false;
        }

        if (ok) {
            mav = new ModelAndView("redirect:qry");

        } else {
            mav.addObject("frases", frases);

            List<Autores> list = servicesAutores.autoresCbo();
            mav.addObject("list", list);
        }

        return mav;
    }

    @GetMapping(value = "/del")
    public ModelAndView del(HttpServletRequest request, Model model) {
        List<Integer> list = DeString.ids(request.getParameter("ids"));

        String result = servicesFrases.frasesDel(list);

        ModelAndView mav = qry(model);
        if (result != null) {
            mav.addObject("msg", result);
        }

        return mav;
    }

    @GetMapping(value = "/get")
    public ModelAndView get(HttpServletRequest request, Model model) {
        Integer idfrase = DeString.aInteger(request.getParameter("idfrase"));

        Frases frases = servicesFrases.frasesGet(idfrase);

        ModelAndView mav = qry(model);
        if (frases != null) {
            List<Autores> list = servicesAutores.autoresCbo();

            mav = new ModelAndView("frasesUpd");
            mav.addObject("list", list);
            mav.addObject(frases);

        } else {
            mav.addObject("msg", "Frase de ID: " + idfrase + ", no registrada");
        }

        return mav;
    }

    @PostMapping(value = "/upd")
    public ModelAndView upd(@ModelAttribute Frases frases, BindingResult bindingResult) {
        FrasesValidator validator = new FrasesValidator();
        validator.validate(frases, bindingResult);

        ModelAndView mav = new ModelAndView("frasesUpd");

        boolean ok = true;
        if (!bindingResult.hasErrors()) { // si no hay errores en envio del cliente
            String result = servicesFrases.frasesInsUpd(frases);

            if (result != null) { // si frases es repetida
                bindingResult.addError(new ObjectError("msg", result));
                ok = false;
            }
        } else { // si hay errores de envio del cliente
            ok = false;
        }

        if (ok) {
            mav = new ModelAndView("redirect:qry");

        } else {
            mav.addObject("frases", frases);

            List<Autores> list = servicesAutores.autoresCbo();
            mav.addObject("list", list);
        }

        return mav;
    }
}
