package com.example.minuevohorario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static ArrayList<Asignatura> asignaturas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addClass = findViewById(R.id.addClass);
        addClass.setOnClickListener(this);
        Button verHorario = findViewById(R.id.verHorario);
        verHorario.setOnClickListener(this);
        Button tocaButton = findViewById(R.id.tocaButton);
        tocaButton.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {

        Intent intent = null;

        switch (v.getId()) {
            case R.id.addClass:
                intent = new Intent(this, NuevaClaseActivity.class);
                startActivity(intent);
                break;
            case R.id.verHorario:
                intent = new Intent(this, VerHorario.class);
                startActivity(intent);
                break;
            case R.id.tocaButton:
                intent = new Intent(this, QueTocaAhora.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}