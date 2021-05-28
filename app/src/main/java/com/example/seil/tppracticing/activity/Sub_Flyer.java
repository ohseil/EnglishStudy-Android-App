package com.example.seil.tppracticing.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.seil.tppracticing.R;

public class Sub_Flyer extends AppCompatActivity {

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub__flyer);

        Intent intent = getIntent();
        if(intent != null) {
            String nnyclass = intent.getStringExtra("nnyclass");
            toast = Toast.makeText(getApplicationContext(), nnyclass, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    protected void onPause() {
        toast.cancel();
        super.onPause();
    }

    public void fm1_Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), Flyer_M1.class);
        intent.putExtra("Fmonth", "Flyer 1st Month");
        startActivityForResult(intent, 1001);
    }
    public void fm2_Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), Flyer_M2.class);
        intent.putExtra("Fmonth", "Flyer 2nd Month");
        startActivityForResult(intent, 1002);
    }
    public void fm3_Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), Flyer_M3.class);
        intent.putExtra("Fmonth", "Flyer 3rd Month");
        startActivityForResult(intent, 1003);
    }
    public void fm4_Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), Flyer_M4.class);
        intent.putExtra("Fmonth", "Flyer 4th Month");
        startActivityForResult(intent, 1004);
    }
    public void fm5_Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), Flyer_Verb.class);
        intent.putExtra("Fmonth", "Flyer Verb Patterns");
        startActivityForResult(intent, 1005);
    }

}
