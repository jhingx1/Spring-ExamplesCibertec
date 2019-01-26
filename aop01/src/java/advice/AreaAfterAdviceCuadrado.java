package advice;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

public class AreaAfterAdviceCuadrado implements AfterReturningAdvice{

    @Override
    public void afterReturning(Object o, Method method, Object[] os, 
            Object o1) throws Throwable {
        
        System.out.println("despues del area del cuadrado");
    }
}

