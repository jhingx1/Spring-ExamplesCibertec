package web.controller;

import dto.Alumnos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.impl.DaoAlumnosImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import model.dao.DaoAlumnos;

@Controller
public class AlumnosController {
    //Injeccion
    private DaoAlumnos daoAlumnos;

    public void setDaoAlumnos(DaoAlumnosImpl daoAlumnos) {
        this.daoAlumnos = daoAlumnos;
    }
    //Fin Injeccion
    @RequestMapping(params = "accion=QRY")
    public ModelAndView alumnosQry() {
        ModelAndView mav = grilla();
        return mav;
    }

    @RequestMapping(params = "accion=INS")
    public ModelAndView alumnosIns(@ModelAttribute Alumnos alumnos) {
        String result = valida(alumnos);

        if (result == null) {            
            result = daoAlumnos.alumnosIns(alumnos);
        }

        ModelAndView mav = grilla();//generando la nueva grilla

        if (result != null) {
            mav.addObject("error", result);
        }

        return mav;
    }

    @RequestMapping(params = "accion=DEL")
    public ModelAndView alumnosDel(HttpServletRequest request) {
        String ids = request.getParameter("ids");
        String result;

        List<Object[]> p_ids = new ArrayList<>();
        if (ids != null) {
            String[] v_id = ids.split(",");

            for (String id : v_id) {
                p_ids.add(new Object[]{Integer.valueOf(id)});
            }

            result = daoAlumnos.alumnosDel(p_ids);

        } else {
            result = "Enviar alumnos a retirar";
        }

        ModelAndView mav = grilla();

        if (result != null) {
            mav.addObject("error", result);
        }

        return mav;
    }

    @RequestMapping(params = "accion=GET")
    public void alumnosGet(HttpServletRequest request,
            HttpServletResponse response) {
        String id = request.getParameter("id");
        String result = null;

        Alumnos alumnos = daoAlumnos.alumnosGet(Integer.valueOf(id));

        if (alumnos != null) {
            result = alumnos.getIdalumno()+ "+++"
                    + alumnos.getNombre()+ "+++"
                    + alumnos.getCorreo()+ "+++"
                    + alumnos.getTelefono();
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
    public ModelAndView alumnosUpd(@ModelAttribute Alumnos alumnos) {
        String result = valida(alumnos);

        if (result == null) {
            result = daoAlumnos.alumnosUpd(alumnos);
        }

        ModelAndView mav = grilla();

        if (result != null) {
            mav.addObject("error", result);
        }

        return mav;
    }

    // apoyo
    private ModelAndView grilla() {
        List<Alumnos> list = daoAlumnos.alumnosQry();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("prod_qry", list);
        
        //para que muestre un popup de un formulario que usa el commandName
        Alumnos alumnos = new Alumnos();
        mav.addObject("alumnos", alumnos);

        return mav;
    }
    
    //Metodo de validacion propio
    private String valida(Alumnos p) {
        String error = null;

        if (p.getNombre().trim().length() == 0) {
            error = "Debe ingresar T&iacute;tulo de Producto";
        }

        if (error == null) {
            if (p.getCorreo().trim().length() == 0) {
                error = "Debe ingresar Tipo de Producto";
            }
        }

        if (error == null) {
            if (p.getTelefono().trim().length() == 0) {
                error = "Debe ingresar Tipo de Producto";
            }
        }

        return error;
    }
}
