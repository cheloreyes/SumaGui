package com.dev.rc.sumagui;

import java.util.Scanner;
import java.util.Date;
/**
 * Interfaz que maneja interaccion con usuario.
 *
 * 
 * @author  FRoM 
 * @version 2014
 */
public class SumaTexto
{
    private Scanner lector;
    private Refuerzo refuerzo;
    private Evaluador evaluador;
    private Generador generador;
    private Registrador registrador;

    public SumaTexto()
    {
        lector = new Scanner( System.in );
        refuerzo = new Refuerzo();
        evaluador = new Evaluador();
        generador = new Generador();
        registrador = new Registrador(); 
    }

    /**
     * Inicia el entrenador. Imprime mensaje de bienvenida e inicia el dialogo con el usuario
     * hasta que ingrese un valor nulo para terminar.
     */
    public void inicia()
    {
        imprimeBienvenida();
        String respuesta = "";

        do {
            generador.genera();
            int n1 = generador.getN1();
            int n2 = generador.getN2();
            int iRta = 0;
            String operacion = n1 + " + " + n2 + " = ";

            System.out.print( operacion );
            respuesta = lector.nextLine();

            try
            {
                iRta = Integer.parseInt( respuesta );
            }
            catch ( NumberFormatException nfe )
            {
                break;
            }

            boolean bRta = evaluador.evalua( n1, n2, iRta );
            Date fecha = new Date();
            String strRegistro = fecha + " " + operacion + respuesta + " " + bRta + "\n";
            // Ahora el refuerzo es un arreglo; el String es el primer elemento: [0].
            System.out.println( refuerzo.getRefuerzo( bRta )[ 0 ] );
            registrador.escriba( strRegistro );

        }while( true );

        registrador.cierra();
        imprimeDespedida();
    }

    private void imprimeBienvenida()
    {
        System.out.println( "Este juego es para el Campeón de las SUMAS = )" );
        System.out.println( "Escribe tu respuesta y oprime Enter. Solo Enter para terminar." );
    }

    private void imprimeDespedida()
    {
        System.out.println( "= ) Gracias por venir a practicar. Eres un CAMPEON !!  = )" );
    }

    public static void main( String[] args )
    {
        new SumaTexto().inicia();
    }    
}
