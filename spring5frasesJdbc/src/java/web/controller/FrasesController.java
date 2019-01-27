package web.controller;

import dao.DaoAutores;
import domain.Frases;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import dao.DaoFrases;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import parainfo.convert.DeString;
import web.validator.FrasesValidator;

@Controller
@RequestMapping("/frases")
public class FrasesController {
    
    @Autowired
    private DaoFrases daoFrases;
    @Autowired
    private DaoAutores daoAutores;
    
    @GetMapping(value = "/qry")
    public ModelAndView frasesQry() {
        ModelAndView mav = new ModelAndView("frasesQry");
        List<Object[]> list = daoFrases.frasesQry();

        if (list != null) {
            mav.addObject("list", list);
        } else {
            mav.addObject("msg", "Sin acceso a base de datos");
        }

        return mav;
    }

    @GetMapping(value = "/ins")
    public ModelAndView frasesIns() {
        List<Object[]> list = daoAutores.autoresCbo();
        Frases frases = new Frases();
        
        ModelAndView mav = new ModelAndView("frasesIns", "frases", frases);
        mav.addObject("list", list);
        
        return mav;
    }

    @PostMapping(value = "/insdb")
    public ModelAndView frasesInsDb(
            @ModelAttribute Frases frases,
            BindingResult bindingResult) {

        FrasesValidator validator = new FrasesValidator();
        validator.validate(frases, bindingResult);

        ModelAndView mav = new ModelAndView("frasesIns");

        if (!bindingResult.hasErrors()) {
            String result = daoFrases.frasesIns(frases);

            if (result == null) {
                mav = new ModelAndView("redirect:qry");

            } else {
                List<Object[]> list = daoAutores.autoresCbo();

                mav.addObject("list", list);
                mav.addObject("frases", frases);
                mav.addObject("msg", result);
            }

        } else {
            List<Object[]> list = daoAutores.autoresCbo();

            mav.addObject("list", list);
            mav.addObject("frases", frases);
            mav.addObject("msg", ""); // permite ver div de errores
        }

        return mav;
    }

    @GetMapping(value = "del")
    public ModelAndView frasesDel(HttpServletRequest request) {
        Integer[] id = DeString.ids(request.getParameter("ids"));

        String result = (id != null)
                ? daoFrases.frasesDel(id)
                : "Lista de IDs incorrecta";

        ModelAndView mav = frasesQry();

        if (result != null) {
            mav.addObject("msg", result);
        } else {
            mav = new ModelAndView("redirect:qry");
        }

        return mav;
    }

    @GetMapping(value = "get")
    public ModelAndView frasesGet(HttpServletRequest request) {
        Integer idfrase = DeString.aInteger(request.getParameter("idfrase"));
        Frases frases = daoFrases.frasesGet(idfrase);
        ModelAndView mav;

        if (frases != null) {
            List<Object[]> list = daoAutores.autoresCbo();
            
            mav = new ModelAndView("frasesUpd", "frases", frases);
            mav.addObject("list", list);
            
        } else { // antes que cambie a null
            String result = "";
            mav = frasesQry(); // message == null
            mav.addObject("msg", result);
        }

        return mav;
    }

    @PostMapping(value = "upd")
    public ModelAndView frasesUpd(
            @ModelAttribute Frases frases,
            BindingResult bindingResult) {

        FrasesValidator validator = new FrasesValidator();
        validator.validate(frases, bindingResult);

        ModelAndView mav = new ModelAndView("frasesUpd");

        if (!bindingResult.hasErrors()) {
            String result = daoFrases.frasesUpd(frases);

            if (result == null) {
                mav = new ModelAndView("redirect:qry");

            } else {
                List<Object[]> list = daoAutores.autoresCbo();
                
                mav.addObject("frases", frases);
                mav.addObject("list", list);
                mav.addObject("msg", result);
            }

        } else {
            List<Object[]> list = daoAutores.autoresCbo();
            
            mav.addObject("frases", frases);
            mav.addObject("list", list);
            mav.addObject("msg", ""); // permite ver div de errores
        }

        return mav;
    }
}
