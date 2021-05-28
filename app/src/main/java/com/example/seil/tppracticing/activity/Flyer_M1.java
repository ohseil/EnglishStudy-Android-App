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

import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M1_CH1;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M1_CH10;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M1_CH11;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M1_CH12;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M1_CH13;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M1_CH2;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M1_CH3;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M1_CH4;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M1_CH5;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M1_CH6;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M1_CH7;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M1_CH8;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M1_CH9;

public class Flyer_M1 extends AppCompatActivity {

    ArrayList<Integer> btnIds = new ArrayList<Integer>(Arrays.asList(R.id.b1, R.id.b2,
            R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9, R.id.b10,
            R.id.b11, R.id.b12, R.id.b13));

    ArrayList<CategoryCode> categories = new ArrayList<CategoryCode>(Arrays.asList(FLYER_M1_CH1, FLYER_M1_CH2,
            FLYER_M1_CH3, FLYER_M1_CH4, FLYER_M1_CH5, FLYER_M1_CH6, FLYER_M1_CH7, FLYER_M1_CH8, FLYER_M1_CH9,
            FLYER_M1_CH10, FLYER_M1_CH11, FLYER_M1_CH12, FLYER_M1_CH13));

    ArrayList<String> titles = new ArrayList<String>(Arrays.asList("Flyer - M1 관념어", "Flyer - M1 Phrasal Verbs (확장판 포함)",
            "Flyer - M1 2형식의 내용을 담고있는 5형식", "Flyer - M1 Verb Clustering (cuase & effect)",
            "Flyer - M1 전치사 with", "Flyer - M1 with 덧붙임 구문", "FLyer - M1 자동사의 수동태",
            "Flyer - M1 수동태 (끝에 부사)", "FLyer - M1 타동사의 수동태", "Flyer - M1 동형사형의 수동태",
            "Flyer - M1 4형식,5형식,subjunctive가 변한 수동태", "Flyer - M1 수동태 의문문", "Flyer - M1 whose,복합관계사"));

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flyer__m1);

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
