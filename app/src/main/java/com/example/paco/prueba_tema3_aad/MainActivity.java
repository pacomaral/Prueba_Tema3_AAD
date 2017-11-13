package com.example.paco.prueba_tema3_aad;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Variables/objetos necesarios
    private Button botonMostrar, botonGuardar;
    private String hora;
    private int dia;
    private static final String PREFERENCES = "Mis preferencias";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recogemos los elementos del layout
        botonGuardar = (Button) findViewById(R.id.botonGuardar);
        botonMostrar = (Button) findViewById((R.id.botonMostrar));


        //Asignamos onClick al botonGuardar
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Abriremos la otra actividad para poder guardar la info
                //Creamos intent
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);

                //Lanzamos actividad
                startActivity(intent);
            }
        });

        //Asignamos onClick al botonMostrar
        botonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   //recogemos los datos del sharedPreferences
                    SharedPreferences sp = getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);
                    dia = sp.getInt("dia", 0);
                    hora = sp.getString("hora", "");

                    //Una vez recogidos, los mostramos en un toast
                    Toast.makeText(getApplicationContext(), "Última toma: " + dia + " a las: " + hora, Toast.LENGTH_LONG).show();

            }
        });
    }
}
