package com.example.javier.tarea02;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ImageView imagen1;
    /*Declarando Variables*/
    String nombres, carrera1, twitter1, github1, correoe, tel;
    TextView nombre1, carrera, twitter, github, correo1, telefono, creador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen1 = (ImageView) findViewById(R.id.prueba);

        ImageView prueba = (ImageView) findViewById(R.id.prueba);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.perfilv);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);

        roundedBitmapDrawable.setCircular(true);
        prueba.setImageDrawable(roundedBitmapDrawable);


    }

    public void compartir(View view) {
        Bitmap bitmap1 = vista(imagen1);

        nombre1 = (TextView) findViewById(R.id.envia1);
        nombres = nombre1.getText().toString();
        carrera = (TextView) findViewById(R.id.envia2);
        carrera1 = carrera.getText().toString();
        twitter = (TextView) findViewById(R.id.envia3);
        twitter1 = twitter.getText().toString();
        github = (TextView) findViewById(R.id.envia4);
        github1 = github.getText().toString();
        correo1 = (TextView) findViewById(R.id.envia5);
        correoe = correo1.getText().toString();
        telefono = (TextView) findViewById(R.id.envia6);
        tel = telefono.getText().toString();
        creador = (TextView) findViewById(R.id.envia7);

        try {
            File file = new File(this.getExternalCacheDir(), "apoyo.png");
            FileOutputStream fuera = new FileOutputStream(file);
            bitmap1.compress(Bitmap.CompressFormat.PNG,100,fuera);
            fuera.flush();
            fuera.close();
            file.setReadable(true, false);
            final Intent comparte = new Intent(android.content.Intent.ACTION_SEND);
            comparte.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            comparte.setType("*/*");
            comparte.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            comparte.putExtra(Intent.EXTRA_TEXT, "Nombre:" + nombres + "\n Carrera:" + carrera1 + "\n" + twitter1 + "\n" + github1 + "\n" + correoe + "\n" + tel);
            startActivity(Intent.createChooser(comparte,"Que programa desea utilizar?"));

        } catch (Exception e) {
            e.printStackTrace();


        }
    }

    private Bitmap vista(View view){
        Bitmap retorna = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas1 = new Canvas(retorna);
        Drawable imag = view.getBackground();

        if(imag !=null){
            imag.draw(canvas1);
        }else{
            canvas1.drawColor(Color.WHITE);

        }
        view.draw(canvas1);
        return retorna;
    }
}