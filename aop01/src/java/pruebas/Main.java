package pruebas;

import com.areas.Areas;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.springframework.core.io.ResourceLoader.CLASSPATH_URL_PREFIX;

public class Main {

    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext context = 
             new ClassPathXmlApplicationContext(CLASSPATH_URL_PREFIX
                + "/spring-aop.xml");
        
        Areas areas = (Areas) context.getBean("proxy");
        
        areas.circulo(10D);
        areas.cuadrado(10D);
    }
}

