package com.jorgesys.customtoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter<String> positionsAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.positions));
        final Spinner spinnerPositions = (Spinner)findViewById(R.id.spinnerPosition);
        spinnerPositions.setAdapter(positionsAdapter);

        ArrayAdapter<String> durationsAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.durations));
        final Spinner spinnerDurations = (Spinner)findViewById(R.id.spinnerDuration);
        spinnerDurations.setAdapter(durationsAdapter);

        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Example: Utilities.showCustomToast("Jorgesys was here!",Utilities.LENGTH_LONG,Utilities.TOAST_CENTER,getApplicationContext());
                Utilities.showCustomToast("Jorgesys was here @ " + spinnerPositions.getSelectedItem().toString(), processDuration(spinnerDurations.getSelectedItem().toString()), processPosition(spinnerPositions.getSelectedItem().toString()),getApplicationContext());
            }
        });

    }

    private int processPosition(String val){
        if(val.equals("TOP")){
            return Utilities.TOAST_TOP;
        }else if(val.equals("CENTER")){
            return Utilities.TOAST_CENTER;
        }else if(val.equals("BOTTOM")){
            return Utilities.TOAST_BOTTOM;
        }else{
            return Utilities.TOAST_CENTER;
        }
    }

    private int processDuration(String val){
        if(val.equals("SHORT")){
            return Utilities.LENGTH_SHORT;
        }else if(val.equals("LONG")){
            return Utilities.LENGTH_LONG;
        }else{
            return Utilities.LENGTH_SHORT;
        }
    }
}
