package com.dev.rc.sumagui;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SumaGuiActivity extends Activity {

    private TextView numUno;
    private TextView numDos;
    private TextView respuesta;
    private TextView refuerzoText;
    private TextView numUnoImg;
    private TextView numDosImg;
    private TextView respuestaImg;
    private boolean clearCero = true;
    private Generador generador;
    private Evaluador evaluador;
    private Refuerzo refuerzo;
    private Registrador registrador;
    private int color;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma_gui);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        numUno = (TextView) findViewById(R.id.first_num);
        numDos = (TextView) findViewById(R.id.second_num);
        respuesta = (TextView) findViewById(R.id.respuesta);
        refuerzoText = (TextView) findViewById(R.id.refuerzo);
        numUnoImg = (TextView) findViewById(R.id.first_n_img);
        numDosImg = (TextView) findViewById(R.id.second_n_img);
        respuestaImg = (TextView) findViewById(R.id.respuesta_img);
        generador = new Generador();
        evaluador = new Evaluador();
        refuerzo = new Refuerzo();
        registrador = new Registrador();
        Typeface type = Typeface.createFromAsset(getAssets(), "fuentes/EraserRegular.ttf");
        refuerzoText.setTypeface(type);
        numUno.setTypeface(type);
        numDos.setTypeface(type);
        respuesta.setTypeface(type);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        iniciaSuma();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_suma_gui, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void buttonClicked(View view) {
        if(view.getId() == R.id.btn_enter){
            int n1 = Integer.parseInt(numUno.getText().toString());
            int n2 = Integer.parseInt(numDos.getText().toString());
            int rta= Integer.parseInt(respuesta.getText().toString());
            actionRespuesta(n1, n2, rta);
            respuesta.setText("0");
            respuestaImg.setText("");
            clearCero = true;
            vibrator.vibrate(300);
        }
        else if(view.getId() == R.id.btn_limpiar){
            vibrator.vibrate(100);
            respuesta.setText("0");
            respuestaImg.setText("");
            clearCero = true;
        }
        else{
            Button btn = (Button) view;
            vibrator.vibrate(50);
            if(clearCero) {
                respuesta.setText(((Button)view).getText());
                clearCero = false;
            }
            else{
                if(respuesta.getText().length() < 2){
                    respuesta.setText(respuesta.getText().toString() + ((Button) view).getText().toString());
                }
            }
            respuestaImg.setText(Figura.getEmoji(Integer.parseInt(respuesta.getText().toString())));
            respuestaImg.setTextColor(color);
            if(Integer.parseInt(respuesta.getText().toString()) > 10) respuestaImg.setTextSize(20);
            else respuestaImg.setTextSize(24);
        }
    }

    private void iniciaSuma(){
        Figura.setFigura();
        generador.genera();
        color = Figura.getColor();
        int n1 = generador.getN1();
        int n2 = generador.getN2();
        numUno.setText(n1 + "");
        numDos.setText(n2 + "");
        //numUnoImg.setText(Figura.getFigura(n1));
        numUnoImg.setText(Figura.getEmoji(n1));
        numUnoImg.setTextColor(color);
        numDosImg.setText(Figura.getEmoji(n2));
        numDosImg.setTextColor(color);
    }

    private void actionRespuesta(int n1, int n2, int rta) {
        int iRta = 0;
        boolean bRta;
        bRta = evaluador.evalua(n1, n2, rta);
        String[] refuerzoStrNav = refuerzo.getRefuerzo(bRta);
        refuerzoText.setText(refuerzoStrNav[0]);
        refuerzoAudio(refuerzoStrNav[1]);
        refuezoVibrator(bRta);
        if(bRta){
            iniciaSuma();
        }
    }
    private void refuerzoAudio(String strAudio) {
        Audio audio = new Audio(this);
        audio.refuerzoAudio(strAudio);
    }

    private void refuezoVibrator(boolean bRta) {
        long[] pattern = {0, 200, 300, 200, 300, 200, 300};

        if(vibrator.hasVibrator()){
            if(bRta){
                vibrator.cancel();
                vibrator.vibrate(pattern, -1);
            }
            else{
                vibrator.vibrate(1000);
            }
        }
    }
}
