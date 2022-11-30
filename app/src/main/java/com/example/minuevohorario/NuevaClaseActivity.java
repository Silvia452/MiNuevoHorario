package com.example.minuevohorario;

import static com.example.minuevohorario.MainActivity.asignaturas;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NuevaClaseActivity extends AppCompatActivity implements Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_class);

        Button anadirBtn = findViewById(R.id.anadirBtn);
        anadirBtn.setOnClickListener((View.OnClickListener) this);
        Button cancelarBtn = findViewById(R.id.cancelarBtn);
        cancelarBtn.setOnClickListener((View.OnClickListener) this);

        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        ArrayAdapter<String> adapterDias =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dias);
        Spinner diaSpinner = findViewById(R.id.diaSpinner);
        diaSpinner.setAdapter(adapterDias);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.anadirBtn:
                EditText nameAsignatura = findViewById(R.id.nameAsignatura);
                Spinner diaSpinner = findViewById(R.id.diaSpinner);
                EditText horaName = findViewById(R.id.horaName);

                String nombre = nameAsignatura.getText().toString();
                String dia = (String) diaSpinner.getSelectedItem();
                String hora = horaName.getText().toString();

                Asignatura asignatura = new Asignatura(nombre, dia, hora);
                asignaturas.add(asignatura);

                nameAsignatura.setText("");
                horaName.setText("");
                diaSpinner.setSelection(0);

                Toast.makeText(this, R.string.mensaje_anadir, Toast.LENGTH_LONG).show();
                break;

            case R.id.cancelarBtn:
                onBackPressed();
                break;
            default:
                break;
        }
    }
}