package com.dev.rc.sumagui; /**
 * Genera pares de enteros a sumar. El tope define cantidad de cifras a trabajar.
 * 
 * FRoM - 2015
 */

import java.util.Random;

public class Generador
{ 
    private int tope = 9;
    private int n1 = 0;    // inicia en el pivote de la operacion
    private int n2 = 0;    // inicia en el pivote de la operacion

    private void Generador()
    {
    }

    private void Generador( int top )
    {
        setTope( top );
    }

    public void genera()
    {
        Random generador = new Random();

        int n = generador.nextInt( tope ) + 1;
        n1 = n;
        n = generador.nextInt( tope ) + 1;         
        n2 = n;
    }

    public void setTope( int top )
    {
        tope = top;
    }

    public int getTope()
    {
        return tope;
    }

    public int getN1()
    {
        return n1;
    }

    public int getN2()
    {
        return n2;
    }
}
