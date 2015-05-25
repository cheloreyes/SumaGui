package com.dev.rc.sumagui;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Registrador conserva en un archivo un registro de todas las operaciones 
 * que ha hecho el usuario con sus aciertos y desaciertos, 
 * util para realizar un analisis de desempeño y realizar ajustes al proceso
 * de aprendizaje.
 * 
 * @author  FRoM 
 * @version 2014
 */
public class Registrador
{
    private FileWriter escribaRegistro;    
    private BufferedWriter bw;

    public Registrador()
    {
        try{
            escribaRegistro = new FileWriter( "registroSuma.txt", true );    
            bw = new BufferedWriter( escribaRegistro );
        }catch( Exception e )
        {
            System.out.println( "NO se pudo abrir archivo registroSuma.txt" );   
        }
    }

    public void escriba( String registro )
    {
        try{
            bw.write( registro );        
        } catch( Exception e ) {
            System.out.println( "NO se pudo escribir en archivo registroSuma.txt" );   
        }
    }

    public void cierra()
    {
        try{
            bw.close();
        } catch( Exception e ) {
            System.out.println( "NO se pudo escribir en archivo registroSuma.txt" );   
        }
    }
}        
