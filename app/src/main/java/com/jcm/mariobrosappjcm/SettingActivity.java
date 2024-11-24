package com.jcm.mariobrosappjcm;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import java.util.Locale;

/**
 * SettingActivity allows the user to change the application's settings,
 * such as the interface language.
 */
public class SettingActivity extends AppCompatActivity {

    private SwitchCompat languageSwitch;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Apply the saved language before setting the content view.
        applySavedLanguage();
        setContentView(R.layout.activity_setting);

        // Configure the language switch (SwitchCompat).
        languageSwitch = findViewById(R.id.language_switch);
        sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);

        // Load the saved language state.
        boolean isEnglish = sharedPreferences.getBoolean("language", false); // False = English, True = Spanish.
        languageSwitch.setChecked(isEnglish);

        // Configure the listener for switch changes.
        languageSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Save the language preference in SharedPreferences.
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("language", isChecked);
            editor.apply();

            // Change the language of the interface.
            toggleLanguage(isChecked);
        });
    }

    /**
     * Changes the application's language and updates the interface.
     *
     * @param isEnglish true for English, false for Spanish.
     */
    private void toggleLanguage(boolean isEnglish) {
        // Save the language in SharedPreferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("language", isEnglish);
        editor.apply();
        Log.d("SettingActivity", "Idioma actual: " + (isEnglish ? "en" : "es"));

        // Reload the activity to apply changes.
        recreate();
    }

    /**
     * Overrides the base context to apply the selected locale.
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        SharedPreferences sharedPreferences = newBase.getSharedPreferences("settings", MODE_PRIVATE);
        boolean isEnglish = sharedPreferences.getBoolean("language", false); // False = English, True = Spanish.

        // Configure the locale.
        Locale locale = isEnglish ? new Locale("en") : new Locale("es");
        Locale.setDefault(locale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.setLocale(locale);

        Log.d("SettingActivity", "Idioma actual: " + (isEnglish ? "en" : "es"));

        // Attach the updated context.
        super.attachBaseContext(newBase.createConfigurationContext(config));
    }

    /**
     * Apply the saved language to the current activity.
     */
    private void applySavedLanguage() {
        SharedPreferences sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);
        boolean isEnglish = sharedPreferences.getBoolean("language", false); // False = English, True = Spanish.

        // Configure the locale.
        Locale locale = isEnglish ? new Locale("en") : new Locale("es");
        Locale.setDefault(locale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.setLocale(locale);

        // Apply the new configuration to the context.
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }
}
