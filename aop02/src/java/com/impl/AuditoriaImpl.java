package com.impl;

import com.Auditoria;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditoriaImpl implements Auditoria {

    @Override
    public void suceso(String accion, String autor) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String t = sdf.format(new Date(System.currentTimeMillis()));

        System.out.println(accion + " por " + autor + " (" + t + ")");
        
        try (FileWriter fichero = new FileWriter("c:/temp/auditoria.txt", true)) {
            PrintWriter pw = new PrintWriter(fichero);

            pw.println(accion + " por " + autor + " (" + t + ")");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
