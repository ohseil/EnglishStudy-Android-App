package com.example.seil.tppracticing.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.seil.tppracticing.R;
import com.example.seil.tppracticing.constantValue.CategoryCode;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M4_CH1;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M4_CH10;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M4_CH11;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M4_CH12;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M4_CH13;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M4_CH2;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M4_CH3;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M4_CH4;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M4_CH5;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M4_CH6;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M4_CH7;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M4_CH8;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M4_CH9;

public class Flyer_M4 extends AppCompatActivity {

    ArrayList<Integer> btnIds = new ArrayList<Integer>(Arrays.asList(R.id.b1, R.id.b2, R.id.b3,
            R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9, R.id.b10, R.id.b11, R.id.b12, R.id.b13));

    ArrayList<CategoryCode> categories = new ArrayList<CategoryCode>(Arrays.asList(FLYER_M4_CH1,
            FLYER_M4_CH2, FLYER_M4_CH3, FLYER_M4_CH4, FLYER_M4_CH5, FLYER_M4_CH6, FLYER_M4_CH7,
            FLYER_M4_CH8, FLYER_M4_CH9, FLYER_M4_CH10, FLYER_M4_CH11, FLYER_M4_CH12, FLYER_M4_CH13));

    ArrayList<String> titles = new ArrayList<String>(Arrays.asList("Flyer - M4 전치사 for",
            "Flyer - M4 subjunctive", "Flyer - M4 화법전환 reported speech part1",
            "Flyer - M4 화법전환 reported speech part2 (간접화법으로 바꾸기)", "Flyer - M4 전치사 of (& from)",
            "Flyer - M4 Noun + to V", "FLyer - M4 어때? (How about N & What about N)", "Flyer - M4 verbal nouns",
            "FLyer - M4 hang up (작은의미) & get off (큰의미)", "Flyer - M4 관사 & 한정사 (articles & determiners)",
            "Flyer - M4 전치사 on", "Flyer - M4 전치사 off", "Flyer - M4 전치사 by"));

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flyer__m4);

        Intent intent = getIntent();
        if(intent != null) {
            String Fmonth = intent.getStringExtra("Fmonth");
            toast = Toast.makeText(getApplicationContext(), Fmonth, Toast.LENGTH_SHORT);
            toast.show();
        }

        setBtn();
    }

    @Override
    protected void onPause() {
        toast.cancel();
        super.onPause();
    }

    public void setBtn() {

        for (int i = 0; i < btnIds.size(); i++) {
            final int idx = i;
            Button btn = (Button) findViewById(btnIds.get(idx));
            btn.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), Q_View.class);
                    intent.putExtra("category", categories.get(idx));
                    intent.putExtra("title", titles.get(idx));
                    startActivity(intent);
                }
            });
        }
    }

}
