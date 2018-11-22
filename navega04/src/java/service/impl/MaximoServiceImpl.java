
package service.impl;

import dto.Alumnos;
import service.MaximoService;

public class MaximoServiceImpl implements MaximoService{

    @Override
    public String maxima(Alumnos alumnos) {
        
        Integer n1 = alumnos.getNota1();
        Integer n2 = alumnos.getNota2();
        Integer n3 = alumnos.getNota3();
        
        Integer max = 0;
        
        max = n1 > max ? n1 : max;
        max = n2 > max ? n2 : max;
        max = n3 > max ? n3 : max;
        
        String msg = alumnos.getNombre() + " tiene nota maxima " + max;
        return  msg;
        
    }
    
}
