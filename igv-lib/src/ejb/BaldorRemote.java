package ejb;

import javax.ejb.Remote;

@Remote
public interface BaldorRemote {

    String calcula(double monto);
    
}
