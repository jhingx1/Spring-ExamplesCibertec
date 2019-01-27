package services.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import services.ServiceTiempo;

@Service
public class ServiceTiempoImpl implements ServiceTiempo{

    @Override
    public String hoy() {
        LocalDateTime dt = LocalDateTime.now();
        String s = dt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a"));
        
        return s;
    }
    
}
