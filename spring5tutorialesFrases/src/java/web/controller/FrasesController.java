package web.controller;

import dao.DaoAutores;
import dao.DaoFrases;
import dto.Frases;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import parainfo.convert.DeString;
import web.validator.FrasesValidator;

@Controller
public class FrasesController {
    
    @Autowired
    private DaoFrases daoFrases;
    @Autowired
    private DaoAutores daoAutores;

    @RequestMapping(params = "QRY")
    public ModelAndView frasesQry() {
        ModelAndView mav = new ModelAndView("frasesQry");
        List<Object[]> list = daoFrases.frasesQry();

        if (list != null) {
            mav.addObject("list", list);
        } else {
            String result = daoFrases.getMessage();
            mav.addObject("msg", result);
        }

        return mav;
    }

    @RequestMapping(params = "INS_FRM")
    public ModelAndView frasesIns() {
        Frases frases = new Frases();
        List<Object[]> list = daoAutores.autoresCbo();

        ModelAndView mav = new ModelAndView(
                "frasesIns", "frases", frases);
        mav.addObject("list", list);

        return mav;
    }

    @RequestMapping(params = "INS_DB")
    public ModelAndView frasesIns(
            @ModelAttribute Frases frases,
            BindingResult bindingResult) {

        FrasesValidator validator = new FrasesValidator();
        validator.validate(frases, bindingResult);

        ModelAndView mav = new ModelAndView("frasesIns");

        if (!bindingResult.hasErrors()) {
            String result = daoFrases.frasesIns(frases);

            if (result == null) {
                mav = new ModelAndView("redirect:frases.htm?QRY");

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
        }

        return mav;
    }

    @RequestMapping(params = "DEL")
    public ModelAndView frasesDel(HttpServletRequest request) {
        Integer[] id = DeString.ids(request.getParameter("ids"));

        String result = (id != null)
                ? daoFrases.frasesDel(id)
                : "Lista de IDs incorrecta";

        ModelAndView mav = frasesQry();

        if (result != null) {
            mav.addObject("msg", result);
        } else {
            mav = new ModelAndView("redirect:frases.htm?QRY");
        }

        return mav;
    }

    @RequestMapping(params = "GET")
    public ModelAndView frasesGet(HttpServletRequest request) {
        Integer idfrase
                = DeString.aInteger(request.getParameter("idfrase"));
        Frases f = daoFrases.frasesGet(idfrase);
        ModelAndView mav;

        if (f != null) {
            List<Object[]> list = daoAutores.autoresCbo();
            
            mav = new ModelAndView("frasesUpd", "frases", f);
            mav.addObject("list", list);
            
        } else { // antes que cambie a null
            String result = daoFrases.getMessage();
            mav = frasesQry(); // message == null
            mav.addObject("msg", result);
        }

        return mav;
    }

    @RequestMapping(params = "UPD")
    public ModelAndView frasesUpd(
            @ModelAttribute Frases frases,
            BindingResult bindingResult) {

        FrasesValidator validator = new FrasesValidator();
        validator.validate(frases, bindingResult);

        ModelAndView mav = new ModelAndView("frasesUpd");

        if (!bindingResult.hasErrors()) {
            String result = daoFrases.frasesUpd(frases);

            if (result == null) {
                mav = new ModelAndView("redirect:frases.htm?QRY");

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
        }

        return mav;
    }
}

