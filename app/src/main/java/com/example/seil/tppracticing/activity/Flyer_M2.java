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

import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M2_CH1;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M2_CH10;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M2_CH11;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M2_CH12;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M2_CH13;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M2_CH14;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M2_CH15;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M2_CH2;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M2_CH3;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M2_CH4;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M2_CH5;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M2_CH6;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M2_CH7;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M2_CH8;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_M2_CH9;

public class Flyer_M2 extends AppCompatActivity {

    ArrayList<Integer> btnIds = new ArrayList<Integer>(Arrays.asList(R.id.b1, R.id.b2, R.id.b3,
            R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9, R.id.b10, R.id.b11,
            R.id.b12, R.id.b13, R.id.b14, R.id.b15));

    ArrayList<CategoryCode> categories = new ArrayList<CategoryCode>(Arrays.asList(FLYER_M2_CH1, FLYER_M2_CH2,
            FLYER_M2_CH3, FLYER_M2_CH4, FLYER_M2_CH5, FLYER_M2_CH6, FLYER_M2_CH7, FLYER_M2_CH8, FLYER_M2_CH9,
            FLYER_M2_CH10, FLYER_M2_CH11, FLYER_M2_CH12, FLYER_M2_CH13, FLYER_M2_CH14, FLYER_M2_CH15));

    ArrayList<String> titles = new ArrayList<String>(Arrays.asList("Flyer - M2 전치수식과 후치수식",
            "Flyer - M2 Way (명사)", "Flyer - M2 If 단순조건문 - 진짜시제", "Flyer - M2 Would의 다양한 활용",
            "Flyer - M2 If 가정법 - 가짜시제 (비현실시제)", "Flyer - M2 If S were to(/should/would) V",
            "Flyer - M2 In ase S+V, If S+V, If S will(/would/were willing to) V", "Flyer - M2 가정법의 다양한 예",
            "Flyer - M2 wish", "Flyer - M2 가정의문문", "Flyer - M2 if 절의 대용", "Flyer - M2 기타 가정법들",
            "Flyer - M2 도치 (inversion)", "Flyer - M2 조동사 Must", "Flyer - M2 조동사 Could"));

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flyer__m2);

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
