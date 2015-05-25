package com.dev.rc.sumagui;


import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.File;
import java.io.*;

/**
 * Audio
 *
 * 
 * @author  FRoM 
 * @version 2014
 */
public class Audio
{
    private Context contexto;
    private MediaPlayer mediaPlayer;

    public Audio(Context context)
    {
        contexto = context;
        mediaPlayer = new MediaPlayer();
    }

    public void refuerzoAudio( String strFile )
    {
        try{
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = new MediaPlayer();
            }
            AssetFileDescriptor descriptor = contexto.getAssets().openFd(strFile);
            mediaPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
