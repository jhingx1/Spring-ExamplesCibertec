package dao.impl;

import com.Auditoria;
import dao.DaoProductos;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.springframework.core.io.ResourceLoader.CLASSPATH_URL_PREFIX;

public class DaoProductosImpl implements DaoProductos {

    @Override
    public String productosIns() {
        audita("INSERT", "Juan Torres");
        return "Insert Ok!";
    }

    @Override
    public String productosDel() {
        audita("DELETE", "Juan Torres");
        return "Delete Ok!";
    }

    @Override
    public String productosUpd() {
        audita("UPDATE", "Juan Torres");
        return "Update Ok!";
    }

    private void audita(String accion, String autor) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext(CLASSPATH_URL_PREFIX
                        + "/spring-aop.xml");
        Auditoria a = (Auditoria) context.getBean("proxy");
        a.suceso(accion, autor);
    }
}
