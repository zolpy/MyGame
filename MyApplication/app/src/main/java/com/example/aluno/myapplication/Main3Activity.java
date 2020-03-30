package com.example.aluno.myapplication;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Main3Activity extends AppCompatActivity implements SensorEventListener {

    SensorManager sm;
    Sensor girometro;

    TextView accX=null;
    TextView accY=null;
    TextView accZ=null;

    DecimalFormat decimal = new DecimalFormat("0.###");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE); //Acessando os sensores
        girometro = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE); //Acessando o acelerometro

        accX = (TextView) findViewById(R.id.X);
        accY = (TextView) findViewById(R.id.Y);
        accZ = (TextView) findViewById(R.id.Z);


    }

    public void Ligar (View view){

        Intent Voltar = new Intent(this, MainActivity.class);

        startActivity(Voltar);

    }

    @Override

    protected void onResume(){
        super.onResume();
        sm.registerListener(this,girometro,SensorManager.SENSOR_DELAY_NORMAL); //Inicia o programa

    }

    @Override

    protected void onPause(){

        super.onPause();
        sm.unregisterListener(this);// para tudo
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        double ax = (event.values[0]);
        double ay = (event.values[1]);
        double az = (event.values[2]);

        String AX = decimal.format(ax);
        String AY = decimal.format(ay);
        String AZ = decimal.format(az);

        accX.setText("X:"+(AX));
        accY.setText("Y:"+(AY));
        accZ.setText("Z:"+(AZ));



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}