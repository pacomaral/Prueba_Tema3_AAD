package com.example.paco.prueba_tema3_aad;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {


    private Button botonGuardar;
    private EditText cajaDia, cajaHora;
    private static final String PREFERENCES = "Mis preferencias";
    private MainActivity act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Recogemos elementos del layout
        botonGuardar = (Button)findViewById(R.id.botonGuardar2);
        cajaDia = (EditText)findViewById(R.id.cajaDia);
        cajaHora = (EditText)findViewById(R.id.cajaHora);

        //Para poder utilizar el setter del semáforo
        act = new MainActivity();


        //Añadimos listener al botón
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Si alguna caja está vacía, mostramos mensaje
                if(String.valueOf(cajaDia.getText()).isEmpty() || String.valueOf(cajaHora.getText()).isEmpty()){
                    Toast.makeText(getApplicationContext(), "Algún dato está vacío", Toast.LENGTH_SHORT).show();
                }
                //Si no, volvemos a la actividad anterior después de guardar preferencias y cambiamos semáforo
                else{
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    SharedPreferences sp = getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();

                    //Guardamos los datos
                    editor.putInt("dia", Integer.valueOf(String.valueOf(cajaDia.getText())));
                    editor.putString("hora", String.valueOf(cajaHora.getText()));

                    editor.commit();

                    startActivity(intent);
                }
            }
        });
    }
}
