package com.example.javier.tarea02;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    TextView nombre1,carrera,twitter,github,correo1,telefono;
    ImageView imagen1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView prueba = (ImageView) findViewById(R.id.prueba);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.perfilv);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),bitmap);

        roundedBitmapDrawable.setCircular(true);
        prueba.setImageDrawable(roundedBitmapDrawable);

        imagen1 = findViewById(R.id.prueba);
        nombre1 = findViewById(R.id.envia1);
        carrera = findViewById(R.id.envia2);
        twitter = findViewById(R.id.envia3);
        github = findViewById(R.id.envia4);
        correo1 = findViewById(R.id.envia5);
        telefono = findViewById(R.id.envia6);

    }

    public void compartir(View view){
        Intent comparte = new Intent();
        comparte.setAction(Intent.ACTION_SEND);
        comparte.setType("text/plain");
        comparte.putExtra(Intent.EXTRA_TEXT, "Nombre:"+nombre1.getText() + "\n Carrera:"+carrera.getText() + "\n"+twitter.getText() + "\n"+github.getText() + "\n"+correo1.getText() + "\n"+telefono.getText());

        if(comparte.resolveActivity(getPackageManager()) !=null){

            startActivity(comparte);
        }

    }



}
