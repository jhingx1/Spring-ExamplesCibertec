package com.areas.impl;

import com.areas.Areas;

public class AreasImpl implements Areas {

    @Override
    public void circulo(Double radio) {
        Double area = Math.PI * Math.pow(radio, 2d);
        System.out.println("si radio " + radio 
                + ", area de circulo: " + area);
    }

    @Override
    public void cuadrado(Double lado) {
        System.out.println("Area del cuadrado" + lado*lado);
    }
}

