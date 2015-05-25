package com.dev.rc.sumagui;

import java.util.ArrayList;
import java.util.Random;
/**
 * Refuerzo entrega refuerzoStrWavs strCorrecto o strIncorrecto de acuerdo
 * a como haya sido la respuesta.
 * 
 * @author  FRoM 
 * @version 2014
 */
public class Refuerzo
{
    private ArrayList< String > strCorrecto;
    private ArrayList< String > strIncorrecto;
    private ArrayList< String > wavCorrecto;
    private ArrayList< String > wavIncorrecto;
    
    private String dir = "sonidos/";    
    
    public Refuerzo()
    {
        strCorrecto = new ArrayList< String >();
        strIncorrecto = new ArrayList< String >();
        wavCorrecto = new ArrayList< String >();
        wavIncorrecto = new ArrayList< String >();
        iniciaStrCorrecto();
        iniciaStrIncorrecto();
        iniciaWavBien();
        iniciaWavMal();
    }

    public String[] getRefuerzo( boolean acierto )
    {
        String refuerzoStrWav[] = new String[2];
        Random genera = new Random();
        int iRefuerzo = genera.nextInt( strCorrecto.size() - 1 );
        
        if( acierto == true )
        {
            refuerzoStrWav[ 0 ] = strCorrecto.get( iRefuerzo );
            refuerzoStrWav[ 1 ] = wavCorrecto.get( iRefuerzo );
        }
        else
        {
            refuerzoStrWav[ 0 ] = strIncorrecto.get( iRefuerzo );
            refuerzoStrWav[ 1 ] = wavIncorrecto.get( iRefuerzo );
        }
        
        return refuerzoStrWav;
    }
    
    private void iniciaStrCorrecto()
    {
        strCorrecto.add( " \u263A Excelente!! " );
        strCorrecto.add( " \u263A Super ! " );
        strCorrecto.add( " Muy bien! \u263A" );
        strCorrecto.add( " \u263A Esplendido! " );
        strCorrecto.add( " \u263A Estupendo! " );
        strCorrecto.add( " Bravo !! \u263A " );
    }
    
    private void iniciaStrIncorrecto()
    {
        strIncorrecto.add( " Humm, no es = ( " );
        strIncorrecto.add( " Prueba otra.." );
        strIncorrecto.add( " Tu puedes !" );
        strIncorrecto.add( " No te desanimes." );
        strIncorrecto.add( " Observa bien.. " );
        strIncorrecto.add( " Intenta de nuevo. " );    }
    
    private void iniciaWavBien()
    {
        wavCorrecto.add( dir + "aplausos.wav" );
        wavCorrecto.add( dir + "cheer.wav" );
        wavCorrecto.add( dir + "crowd.wav" );
        wavCorrecto.add( dir + "loveU.wav" );
        wavCorrecto.add( dir + "rudy.wav" );
        wavCorrecto.add( dir + "sweep.wav" );
    }
    
    private void iniciaWavMal()
    {
        wavIncorrecto.add( dir + "laser.wav" );
        wavIncorrecto.add( dir + "poke.wav" );
        wavIncorrecto.add( dir + "register.wav" );
        wavIncorrecto.add( dir + "sad.wav" );
        wavIncorrecto.add( dir + "star.wav" );
        wavIncorrecto.add( dir + "teaspoon.wav" );
    }
}
