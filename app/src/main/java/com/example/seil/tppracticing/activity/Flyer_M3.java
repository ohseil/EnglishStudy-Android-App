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

import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M3_CH1;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M3_CH10;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M3_CH2;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M3_CH3;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M3_CH4;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M3_CH5;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M3_CH6;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M3_CH7;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M3_CH8;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M3_CH9;

public class Flyer_M3 extends AppCompatActivity {

    ArrayList<Integer> btnIds = new ArrayList<Integer>(Arrays.asList(R.id.b1, R.id.b2,
            R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9, R.id.b10));

    ArrayList<CategoryCode> categories = new ArrayList<CategoryCode>(Arrays.asList(FLYER_M3_CH1,
            FLYER_M3_CH2, FLYER_M3_CH3, FLYER_M3_CH4, FLYER_M3_CH5, FLYER_M3_CH6, FLYER_M3_CH7,
            FLYER_M3_CH8, FLYER_M3_CH9, FLYER_M3_CH10));

    ArrayList<String> titles = new ArrayList<String>(Arrays.asList("Flyer - M3 Reflexive Pronoun (재귀대명사)",
            "Flyer - M3 it 용법 총정리", "Flyer - M3 be supposed to V", "Flyer - M3 비교 총정리",
            "Flyer - M3 접속사", "Flyer - M3 전치사 at", "FLyer - M3 전치사 in", "Flyer - M3 품사무시 영역훈련",
            "FLyer - M3 전치사 to", "Flyer - M3 전치사 into"));

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flyer__m3);

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
