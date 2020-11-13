package com.example.my1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.my1.SaveSettings.firstVisit;


public class MainActivity extends AppCompatActivity {
    private int counter = 0;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        counter++;
        super.onStart();
        getParametersCity();
        defaultSetting();
        Log.i(TAG, "onStart");
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    private void getParametersCity(){
        if(!firstVisit){
            Log.i(TAG, "getParametersCity, counter " + counter);
            String city = getIntent().getExtras().getString(SaveSettings.CITY);
            TextView textView = findViewById(R.id.cityMain);
            textView.setText(city);
        }
    }

    private void defaultSetting(){
        if(firstVisit){
            TextView textView = findViewById(R.id.cityMain);
            textView.setText(SettingsActivity.cities[1]);
            Log.i(TAG, "defaultSetting");
            firstVisit = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "checkBoxWindSpeed counted");
        Toast.makeText(this, "onRestoreInstanceState", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    public void show(View view){
        Toast.makeText(this, R.string.weather, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Просмотр погоды");
        Toast.makeText(this, "show", Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
        Log.i(TAG, "onClick Setting");
        Toast.makeText(this, "onClick Setting", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    public void infoCity(View view) {
        Uri infoCity = Uri.parse("https://ru.wikipedia.org/wiki/Ростов");
        Intent intent = new Intent(Intent.ACTION_VIEW, infoCity);
        startActivity(intent);
    }
}