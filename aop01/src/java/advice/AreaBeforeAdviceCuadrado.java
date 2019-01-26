package advice;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class AreaBeforeAdviceCuadrado implements MethodBeforeAdvice{

    @Override
    public void before(Method method, Object[] os, Object o) 
            throws Throwable {
        
        System.out.println("antes del area de cuadrado");
    }
}

