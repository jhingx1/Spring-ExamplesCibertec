
package ejb;

import javax.ejb.Remote;

@Remote
public interface PalmaRemote {

    String saludo(String nombre);
    
}
