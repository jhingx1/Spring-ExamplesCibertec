/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;

/**
 *
 * @author JAdv-VS
 */
@Stateless
public class suma implements sumaRemote {

    @Override
    public Integer suma(int n1, int n2) {
        return n1+n2;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
