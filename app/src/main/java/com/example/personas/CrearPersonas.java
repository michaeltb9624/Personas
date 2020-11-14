package com.example.personas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CrearPersonas extends AppCompatActivity {

    private EditText cedula , nombre, apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_personas);
        cedula = findViewById(R.id.txtCedula);
        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);
    }

    public void guardar (View v){
        String ced, nom,apell;
        Persona p;
        if(validar()) {
            ced = cedula.getText().toString();
            nom = nombre.getText().toString();
            apell = apellido.getText().toString();
            p = new Persona(ced, nom, apell);
            p.guardar();
            Toast.makeText(this, R.string.mensaje_guardado_exitoso, Toast.LENGTH_LONG).show();
            limpiar();
        }
    }

    public void limpiar (View v){
        limpiar();
    }

    public void limpiar(){
        cedula.setText("");
        nombre.setText("");
        apellido.setText("");
        cedula.requestFocus();
    }

    public boolean validar(){
        if(cedula.getText().toString().isEmpty()){
            cedula.setError(getString(R.string.ingrese_cedula));
            cedula.requestFocus();
            return false;
        }
        if(nombre.getText().toString().isEmpty()){
            nombre.setError(getString(R.string.ingrese_nombre));
            nombre.requestFocus();
            return false;
        }
        if(apellido.getText().toString().isEmpty()){
            apellido.setError(getString(R.string.ingrese_apellido));
            apellido.requestFocus();
            return false;
        }
        return true;
    }
}