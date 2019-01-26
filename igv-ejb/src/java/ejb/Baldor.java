package ejb;

import java.util.Locale;
import javax.ejb.Stateless;

@Stateless
public class Baldor implements BaldorRemote {

    @Override
    public String calcula(double monto) {
        
        double total = monto*1.18;        
        String resultado = String.format(Locale.US, "%1.2f",total);        
        return resultado;
        
    }

}
