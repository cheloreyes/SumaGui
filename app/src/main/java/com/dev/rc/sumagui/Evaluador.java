package com.dev.rc.sumagui;


/**
 * Evaluador toma los operandos y responde con true o false segun sea o no correcta
 * la respuesta del usuario.
 * 
 * @author  FRoM 
 * @version 2014
 */
public class Evaluador
{
   
    public boolean evalua( int operando1, int operando2, int respuesta  )
    {
        int valor = operando1 + operando2;
        
        if( valor == respuesta )
        {
            return true;
        }
        else
        {
            return false;
        }
    }    
}
