package com.dev.rc.sumagui;
/**
 * Figura
 *
 * 
 * @author  FRoM 
 * @version 2014
 */

import android.content.Context;
import android.graphics.Color;

import com.vdurmont.emoji.EmojiParser;

import java.util.Random;
import java.util.List;

public class Figura
{
    public static final int BOLAS_X_LINEA = 9;
    public static final int N_COLORES = 7;
    public static final int N_CARACTERES = 7;
    public static List<String> colores;
    
    private static Character caracter;
    private static int color;
    private static String emojis;


    public Figura()
    {
    }
    
    public static void setFigura()
    {
        setCaracter();
        setColor();
    }

    public static int setColor()
    {
        Random ale = new Random();
        switch( ale.nextInt( N_COLORES ) + 1 )
        {
            case 1: color = Color.BLUE;
            break;
            case 2: color = Color.BLACK;
            break;
            case 3: color = Color.GREEN;
            break;
            case 4: color = Color.LTGRAY;
            break;
            case 5: color = Color.RED;
            break; 
            case 6: color = Color.MAGENTA;
            break; 
            case 7: color = Color.GRAY;
            break; 
            default: color = Color.BLUE;
            break;
        }
        return color;
    }
    
    private static void setCaracter()
    {
        String[] aliases = {"wine_glass", "egg", "rabbit", "cow2", "smile_cat", "panda_face",
                "heart_eyes_cat", "v", "notes", "musical_note", "hand", "blue_car", "coffee", "gift",
                "bulb", "mailbox", "tropical_fish", "rose"};
        Random ale = new Random();
        emojis = EmojiParser.parseToUnicode(":" + aliases[ale.nextInt(aliases.length)] + ":");
        switch( ale.nextInt( N_CARACTERES + 1  ) )
        {
            case 1: caracter = '\u25CF';
            break;
            case 2: caracter = '\u263A';
            break;
            case 3: caracter = '\u2665';
            break;
            case 4: caracter = '\u2602';
            break;
            case 5: caracter = '\u265E';
            break; 
            case 6: caracter = '\u2605';
            break; 
            case 7: caracter = '\u266A';
            break;
            default: caracter = '\u2666';
            break;
        }
    }
    
    public static int getColor()
    {
        return color;
    }
    
    private static Character getCaracter()
    {
        return caracter;
    }

    public static String getFigura( int n )
    {
        String strBolas = "";
        caracter = getCaracter();

        for( int i = 1; i <= n; i++ )
        {        
            strBolas = strBolas  + caracter;
            if( i % BOLAS_X_LINEA == 0 )
                strBolas = strBolas  + "\n";            
        }

        return strBolas;
    }

    public static String getEmoji(int n) {
        String strEmoji = "";
        for (int i = 1; i <= n; i++) {
            strEmoji = strEmoji + emojis;
            if(i % BOLAS_X_LINEA == 0) strEmoji = strEmoji + "\n";
        }
        return strEmoji;
    }
}
