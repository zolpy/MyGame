package com.example.aluno.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void Acelerometro(View view) {

        Intent Acelerometro = new Intent(this, Main2Activity.class);

        startActivity(Acelerometro);

    }

    public void Girometro(View view) {

        Intent Girometro = new Intent(this, Main3Activity.class);

        startActivity(Girometro);

    }

    public void Sair(View view) {

        Intent Sair = new Intent(Intent.ACTION_MAIN);
        Sair.addCategory(Intent.CATEGORY_HOME);
        Sair.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(Sair);

    }
}