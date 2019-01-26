package web.controller;

import dao.DaoProductos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataController {

    private DaoProductos daoProductos;

    public void setDaoProductos(DaoProductos daoProductos) {
        this.daoProductos = daoProductos;
    }

    @RequestMapping(params = "insert")
    public ModelAndView insert() {
        String msg = daoProductos.productosIns();

        ModelAndView mav = new ModelAndView("result", "msg", msg);
        return mav;
    }

    @RequestMapping(params = "delete")
    public ModelAndView delete() {
        String msg = daoProductos.productosDel();

        ModelAndView mav = new ModelAndView("result", "msg", msg);
        return mav;
    }

    @RequestMapping(params = "update")
    public ModelAndView update() {
        String msg = daoProductos.productosUpd();

        ModelAndView mav = new ModelAndView("result", "msg", msg);
        return mav;
    }
}
