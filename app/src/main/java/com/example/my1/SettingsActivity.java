package com.example.my1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class SettingsActivity extends Activity {

    private static final String TAG = SettingsActivity.class.getSimpleName();
    private CheckBox checkBoxWindSpeed;
    private CheckBox checkBoxPressure;
    private boolean checkBoxWindSpeedIsChecked;
    private static final String KEY_WIN_SPEED = "checkBoxWindSpeedIsChecked";
    TextView selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        selection = (TextView) findViewById(R.id.settings);
        Spinner spinner = (Spinner) findViewById(R.id.cities);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SaveSettings.cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                selection.setText(item);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
    }


    private boolean checkBoxWindSpeedIsChecked(){
        if (checkBoxWindSpeed.isChecked()){
            checkBoxWindSpeedIsChecked = true;
            Log.i(TAG, "checkBoxWindSpeedIsChecked true");
        } else {
            checkBoxWindSpeedIsChecked = false;
            Log.i(TAG, "checkBoxWindSpeedIsChecked false");
        }
        return checkBoxWindSpeedIsChecked;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(TAG, "checkBoxWindSpeed save");
        checkBoxWindSpeedIsChecked();
        outState.putBoolean(KEY_WIN_SPEED, checkBoxWindSpeedIsChecked);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        checkBoxWindSpeedIsChecked = savedInstanceState.getBoolean(KEY_WIN_SPEED);
        Log.i(TAG, "checkBoxWindSpeed counted");
    }

    public void okSettingOnClick(View view) {
        onPause();
        Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
        intent.putExtra(SaveSettings.CITY, city());
        startActivity(intent);
        Log.i(TAG, "onClick Ok_Settings");
        Toast.makeText(getApplicationContext(), "onClick Ok_Settings", Toast.LENGTH_SHORT).show();
    }

    public String city(){
        Spinner spinner = findViewById(R.id.cities);
        String selected = spinner.getSelectedItem().toString();
        return selected;
    }


    @Override
    protected void onPause() {
        super.onPause();
    }
}
