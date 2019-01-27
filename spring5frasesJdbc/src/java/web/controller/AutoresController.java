package web.controller;

import domain.Autores;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import dao.DaoAutores;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import parainfo.convert.DeString;
import web.validator.AutoresValidator;

@Controller
@RequestMapping("/autores")
public class AutoresController {
    
    @Autowired
    private DaoAutores daoAutores;
    
    @GetMapping(value = "/qry")
    public ModelAndView autoresQry() {
        ModelAndView mav = new ModelAndView("autoresQry");
        List<Autores> list = daoAutores.autoresQry();

        if (list != null) {
            mav.addObject("list", list);
        } else {
            mav.addObject("msg", "Sin acceso a base de datos");
        }

        return mav;
    }

    @GetMapping(value = "/ins")
    public ModelAndView autoresIns() {
        Autores autores = new Autores();
        ModelAndView mav = new ModelAndView(
                "autoresIns", "autores", autores);
        return mav;
    }

    @PostMapping(value = "/insdb")
    public ModelAndView autoresInsDb(
            @ModelAttribute Autores autores,
            BindingResult bindingResult) {

        AutoresValidator validator = new AutoresValidator();
        validator.validate(autores, bindingResult);

        ModelAndView mav = new ModelAndView("autoresIns");

        if (!bindingResult.hasErrors()) {
            String result = daoAutores.autoresIns(autores);

            if (result == null) {
                mav = new ModelAndView("redirect:qry");

            } else {
                mav.addObject("autores", autores);
                mav.addObject("msg", result);
            }

        } else {
            mav.addObject("autores", autores);
            mav.addObject("msg", ""); // permite ver div de errores
        }

        return mav;
    }

    @GetMapping(value = "del")
    public ModelAndView autoresDel(HttpServletRequest request) {
        Integer[] id = DeString.ids(request.getParameter("ids"));

        String result = (id != null)
                ? daoAutores.autoresDel(id)
                : "Lista de IDs incorrecta";

        ModelAndView mav = autoresQry();

        if (result != null) {
            mav.addObject("msg", result);
        } else {
            mav = new ModelAndView("redirect:qry");
        }

        return mav;
    }

    @GetMapping(value = "get")
    public ModelAndView autoresGet(HttpServletRequest request) {
        Integer idautor = DeString.aInteger(request.getParameter("idautor"));
        Autores autores = daoAutores.autoresGet(idautor);
        ModelAndView mav;

        if (autores != null) {
            mav = new ModelAndView("autoresUpd", "autores", autores);
            
        } else { // antes que cambie a null
            String result = "";
            mav = autoresQry(); // message == null
            mav.addObject("msg", result);
        }

        return mav;
    }

    @PostMapping(value = "upd")
    public ModelAndView autoresUpd(
            @ModelAttribute Autores autores,
            BindingResult bindingResult) {

        AutoresValidator validator = new AutoresValidator();
        validator.validate(autores, bindingResult);

        ModelAndView mav = new ModelAndView("autoresUpd");

        if (!bindingResult.hasErrors()) {
            String result = daoAutores.autoresUpd(autores);

            if (result == null) {
                mav = new ModelAndView("redirect:qry");

            } else {
                mav.addObject("autores", autores);
                mav.addObject("msg", result);
            }

        } else {
            mav.addObject("autores", autores);
            mav.addObject("msg", ""); // permite ver div de errores
        }

        return mav;
    }
}
