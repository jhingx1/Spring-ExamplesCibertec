package web.controller;

import dao.DaoTutoriales;
import dto.Tutoriales;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import parainfo.convert.DeString;
import web.validator.TutorialesValidator;

@Controller
@RequestMapping("/tutoriales")
public class TutorialesController {

    @Autowired
    private DaoTutoriales daoTutoriales;
    
    @GetMapping(value = "/qry")
    public ModelAndView tutorialesQry() {
        ModelAndView mav = new ModelAndView("tutorialesQry");
        List<Tutoriales> list = daoTutoriales.tutorialesQry();

        if (list != null) {
            mav.addObject("list", list);
        } else {
            mav.addObject("msg", "Sin acceso a base de datos");
        }

        return mav;
    }

    @GetMapping(value = "/ins")
    public ModelAndView tutorialesIns() {
        Tutoriales tutoriales = new Tutoriales();
        ModelAndView mav = new ModelAndView(
                "tutorialesIns", "tutoriales", tutoriales);
        return mav;
    }

    @PostMapping(value = "/insdb")
    public ModelAndView tutorialesIns(
            @ModelAttribute Tutoriales tutoriales,
            BindingResult bindingResult) {

        TutorialesValidator validator = new TutorialesValidator();
        validator.validate(tutoriales, bindingResult);

        ModelAndView mav = new ModelAndView("tutorialesIns");

        if (!bindingResult.hasErrors()) {
            String result = daoTutoriales.tutorialesIns(tutoriales);

            if (result == null) {
                mav = new ModelAndView("redirect:qry");

            } else {
                mav.addObject("tutoriales", tutoriales);
                mav.addObject("msg", result);
            }

        } else {
            mav.addObject("tutoriales", tutoriales);
            mav.addObject("msg", ""); // permite ver div de errores
        }

        return mav;
    }

    @GetMapping(value = "del")
    public ModelAndView tutorialesDel(HttpServletRequest request) {
        Integer[] id = DeString.ids(request.getParameter("ids"));

        String result = (id != null)
                ? daoTutoriales.tutorialesDel(id)
                : "Lista de IDs incorrecta";

        ModelAndView mav = tutorialesQry();

        if (result != null) {
            mav.addObject("msg", result);
        } else {
            mav = new ModelAndView("redirect:qry");
        }

        return mav;
    }

    @GetMapping(value = "get")
    public ModelAndView tutorialesGet(HttpServletRequest request) {
        Integer idtutorial = DeString.aInteger(request.getParameter("idtutorial"));
        Tutoriales t = daoTutoriales.tutorialesGet(idtutorial);
        ModelAndView mav;

        if (t != null) {
            mav = new ModelAndView("tutorialesUpd", "tutoriales", t);
            
        } else { // antes que cambie a null
            String result = "";
            mav = tutorialesQry(); // message == null
            mav.addObject("msg", result);
        }

        return mav;
    }

    @PostMapping(value = "upd")
    public ModelAndView tutorialesUpd( 
            @ModelAttribute Tutoriales tutoriales,
            BindingResult bindingResult) {

        TutorialesValidator validator = new TutorialesValidator();
        validator.validate(tutoriales, bindingResult);

        ModelAndView mav = new ModelAndView("tutorialesUpd");

        if (!bindingResult.hasErrors()) {
            String result = daoTutoriales.tutorialesUpd(tutoriales);

            if (result == null) {
                mav = new ModelAndView("redirect:qry");

            } else {
                mav.addObject("tutoriales", tutoriales);
                mav.addObject("msg", result);
            }

        } else {
            mav.addObject("tutoriales", tutoriales);
            mav.addObject("msg", ""); // permite ver div de errores
        }

        return mav;
    }
}

