package web.controller;

import dao.DaoAutores;
import dto.Autores;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import parainfo.convert.DeString;
import web.validator.AutoresValidator;

@Controller
@RequestMapping("/autores")
public class AutoresController {
    
    @Autowired
    private DaoAutores daoAutores;

    @RequestMapping(params = "QRY")
    public ModelAndView autoresQry() {
        ModelAndView mav = new ModelAndView("autoresQry");
        List<Autores> list = daoAutores.autoresQry();

        if (list != null) {
            mav.addObject("list", list);
        } else {
            String result = daoAutores.getMessage();
            mav.addObject("msg", result);
        }

        return mav;
    }

    @RequestMapping(params = "INS_FRM")
    public ModelAndView autoresIns() {
        Autores autores = new Autores();
        ModelAndView mav = new ModelAndView(
                "autoresIns", "autores", autores);
        return mav;
    }

    @RequestMapping(params = "INS_DB")
    public ModelAndView autoresIns(
            @ModelAttribute Autores autores,
            BindingResult bindingResult) {

        AutoresValidator validator = new AutoresValidator();
        validator.validate(autores, bindingResult);

        ModelAndView mav = new ModelAndView("autoresIns");

        if (!bindingResult.hasErrors()) {
            String result = daoAutores.autoresIns(autores);

            if (result == null) {
                mav = new ModelAndView("redirect:autores.htm?QRY");

            } else {
                mav.addObject("autores", autores);
                mav.addObject("msg", result);
            }

        } else {
            mav.addObject("autores", autores);
        }

        return mav;
    }

    @RequestMapping(params = "DEL")
    public ModelAndView autoresDel(HttpServletRequest request) {
        Integer[] id = DeString.ids(request.getParameter("ids"));

        String result = (id != null)
                ? daoAutores.autoresDel(id)
                : "Lista de IDs incorrecta";

        ModelAndView mav = autoresQry();

        if (result != null) {
            mav.addObject("msg", result);
        } else {
            mav = new ModelAndView("redirect:autores.htm?QRY");
        }

        return mav;
    }

    @RequestMapping(params = "GET")
    public ModelAndView autoresGet(HttpServletRequest request) {
        Integer idautor
                = DeString.aInteger(request.getParameter("idautor"));
        Autores a = daoAutores.autoresGet(idautor);
        ModelAndView mav;

        if (a != null) {
            mav = new ModelAndView("autoresUpd", "autores", a);
        } else { // antes que cambie a null
            String result = daoAutores.getMessage();
            mav = autoresQry(); // message == null
            mav.addObject("msg", result);
        }

        return mav;
    }

    @RequestMapping(params = "UPD")
    public ModelAndView autoresUpd(
            @ModelAttribute Autores autores,
            BindingResult bindingResult) {

        AutoresValidator validator = new AutoresValidator();
        validator.validate(autores, bindingResult);

        ModelAndView mav = new ModelAndView("autoresUpd");

        if (!bindingResult.hasErrors()) {
            String result = daoAutores.autoresUpd(autores);

            if (result == null) {
                mav = new ModelAndView("redirect:autores.htm?QRY");

            } else {
                mav.addObject("autores", autores);
                mav.addObject("msg", result);
            }

        } else {
            mav.addObject("autores", autores);
        }

        return mav;
    }
}

