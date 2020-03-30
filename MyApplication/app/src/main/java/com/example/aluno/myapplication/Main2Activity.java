
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

public class Main2Activity extends AppCompatActivity implements SensorEventListener {

    SensorManager sm;
    Sensor acelerometro;

    TextView accX=null;
    TextView accY=null;
    TextView accZ=null;
    View view;

    DecimalFormat decimal = new DecimalFormat("0.###");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE); //Acessando os sensores
        acelerometro = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER); //Acessando o acelerometro

        accX = (TextView) findViewById(R.id.X);
        accY = (TextView) findViewById(R.id.Y);
        accZ = (TextView) findViewById(R.id.Z);
        view = findViewById(R.id.Tela);


    }

    public void Ligar (View view){

        Intent Voltar = new Intent(this, MainActivity.class);

        startActivity(Voltar);

    }

    @Override

    protected void onResume(){
        super.onResume();
        sm.registerListener(this, acelerometro,SensorManager.SENSOR_DELAY_NORMAL); //Inicia o programa

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

        if(Math.abs(ax) > 9.0){
            view.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        }

        if(Math.abs(ay) > 9.0){
            view.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
        }

        if(Math.abs(az) > 9.0){
            view.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
        }



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
