package web.controller;

import dto.Tutoriales;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.impl.DaoTutorialesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import model.dao.DaoTutoriales;

@Controller
public class TutorialesController {
    //Injeccion
    private DaoTutoriales daoTutoriales;

    public void setDaoTutoriales(DaoTutorialesImpl daoTutoriales) {
        this.daoTutoriales = daoTutoriales;
    }
    //Fin Injeccion
    @RequestMapping(params = "accion=QRY")
    public ModelAndView tutorialesQry() {
        ModelAndView mav = grilla();
        return mav;
    }

    @RequestMapping(params = "accion=INS")
    public ModelAndView tutorialesIns(@ModelAttribute Tutoriales tutoriales) {
        String result = valida(tutoriales);

        if (result == null) {
            result = daoTutoriales.tutorialesIns(tutoriales);
        }

        ModelAndView mav = grilla();//generando la nueva grilla

        if (result != null) {
            mav.addObject("error", result);
        }

        return mav;
    }

    @RequestMapping(params = "accion=DEL")
    public ModelAndView tutorialesDel(HttpServletRequest request) {
        String ids = request.getParameter("ids");
        String result;

        List<Object[]> p_ids = new ArrayList<>();
        if (ids != null) {
            String[] v_id = ids.split(",");

            for (String id : v_id) {
                p_ids.add(new Object[]{Integer.valueOf(id)});
            }

            result = daoTutoriales.tutorialesDel(p_ids);

        } else {
            result = "Enviar tutoriales a retirar";
        }

        ModelAndView mav = grilla();

        if (result != null) {
            mav.addObject("error", result);
        }

        return mav;
    }

    @RequestMapping(params = "accion=GET")
    public void tutorialesGet(HttpServletRequest request,
            HttpServletResponse response) {
        String id = request.getParameter("id");
        String result = null;

        Tutoriales tutoriales = daoTutoriales.tutorialesGet(Integer.valueOf(id));

        if (tutoriales != null) {
            result = tutoriales.getIdtutorial() + "+++"
                    + tutoriales.getTitulo() + "+++"
                    + tutoriales.getTipo() + "+++"
                    + tutoriales.getPrecio();
        }

        if (result != null) { // resultado de solicitud ajax
            response.setContentType("text/html;charset=UTF-8");

            try (PrintWriter out = response.getWriter()) {
                out.print(result);
                
            } catch(IOException e) {
            }
        }
    }

    @RequestMapping(params = "accion=UPD")
    public ModelAndView tutorialesUpd(@ModelAttribute Tutoriales tutoriales) {
        String result = valida(tutoriales);

        if (result == null) {
            result = daoTutoriales.tutorialesUpd(tutoriales);
        }

        ModelAndView mav = grilla();

        if (result != null) {
            mav.addObject("error", result);
        }

        return mav;
    }

    // apoyo
    private ModelAndView grilla() {
        List<Tutoriales> list = daoTutoriales.tutorialesQry();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("prod_qry", list);
        
        //para que muestre un popup de un formulario que usa el commandName
        Tutoriales tutoriales = new Tutoriales();
        mav.addObject("tutoriales", tutoriales);

        return mav;
    }
    
    //Metodo de validacion propio
    private String valida(Tutoriales p) {
        String error = null;

        if (p.getTitulo().trim().length() == 0) {
            error = "Debe ingresar T&iacute;tulo de Producto";
        }

        if (error == null) {
            if (p.getTipo().trim().length() == 0) {
                error = "Debe ingresar Tipo de Producto";
            }
        }

        if (error == null) {
            if ((p.getPrecio() == null) || (p.getPrecio() <= 0)) {
                error = "Debe ingresar Precio de Producto";
            }
        }

        return error;
    }
}
