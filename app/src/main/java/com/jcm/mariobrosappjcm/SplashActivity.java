package com.jcm.mariobrosappjcm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configurar el layout de la pantalla Splash
        setContentView(R.layout.activity_splash);

        // Configurar un temporizador de 3 segundos
        new Handler().postDelayed(() -> {
            // Redirigir al MainActivity
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Finalizar la actividad Splash
        }, 3000); // 3000ms = 3 segundos
    }
}
