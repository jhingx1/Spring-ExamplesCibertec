package ejb;

import javax.ejb.Stateless;

@Stateless
public class Palma implements PalmaRemote {

    @Override
    public String saludo(String nombre) {
        return "Bienvenido " + nombre + " a los EJBs";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    
}
