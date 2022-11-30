package com.example.minuevohorario;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateUtils;
import android.widget.TextView;
import android.app.Activity;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.example.minuevohorario.MainActivity.asignaturas;
import static com.example.minuevohorario.DateUtils.diaOrdinal;

public class QueTocaAhora extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_que_toca_ahora);

        TextView loQueToca = findViewById(R.id.loQueToca);

        int diaHoy = new GregorianCalendar().get(Calendar.DAY_OF_WEEK);
        int horaAhora = new GregorianCalendar().get(Calendar.HOUR);
        for (Asignatura asignatura : asignaturas) {
            if (diaOrdinal(asignatura.getDia()) == diaHoy) {
                if (Integer.parseInt(asignatura.getHora()) == horaAhora) {
                    loQueToca.setText("Te toca ir a clase de " + asignatura.getNombre());
                    return;
                }

            }
        }

        loQueToca.setText("Ahora toca tiempo Libre! " + diaHoy + " " + horaAhora);
    }

}
