package com.jcm.mariobrosappjcm;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import java.util.Locale;

/**
 * SettingActivity permite al usuario cambiar la configuración de la aplicación,
 * como el idioma de la interfaz.
 */
public class SettingActivity extends AppCompatActivity {

    private SwitchCompat languageSwitch;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        // Configurar el interruptor de idioma (SwitchCompat).
        languageSwitch = findViewById(R.id.language_switch);
        sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);

        // Cargar el estado del idioma guardado.
        boolean isEnglish = sharedPreferences.getBoolean("language", false); // False = Inglés, True = Español.
        languageSwitch.setChecked(isEnglish);

        // Configurar el listener para cambios en el interruptor.
        languageSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Guardar la preferencia de idioma en SharedPreferences.
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("language", isChecked);
            editor.apply();

            // Cambiar el idioma de la interfaz.
            toggleLanguage(isChecked);
        });
    }

    /**
     * Cambia el idioma de la aplicación y actualiza la interfaz.
     *
     * @param isEnglish true si se selecciona inglés, false si se selecciona español.
     */
    private void toggleLanguage(boolean isEnglish) {
        // Configurar el idioma según la selección.
        Locale locale = isEnglish ? new Locale("en") : new Locale("es");
        Locale.setDefault(locale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        // Mostrar un mensaje indicando que el idioma ha cambiado.
        Toast.makeText(this, R.string.languageChanged, Toast.LENGTH_SHORT).show();

        // Recargar la actividad para aplicar los cambios.
        recreate();
    }
}

