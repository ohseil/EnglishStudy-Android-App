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

import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_1;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_10;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_11;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_12;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_13;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_14;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_15;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_16;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_17;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_18;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_19;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_2;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_20;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_21;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_22;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_23;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_24;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_25;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_26;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_27;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_28;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_29;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_3;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_30;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_31;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_32;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_33;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_34;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_35;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_36;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_37;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_38;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_4;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_5;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_6;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_7;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_8;
import static com.example.seil.tppracticing.constantValue.CategoryCode.CHALLENGER_CHAPTER_9;

public class Challenger extends AppCompatActivity {

    ArrayList<Integer> btnIds = new ArrayList<Integer>(Arrays.asList(R.id.b1, R.id.b2, R.id.b3, R.id.b4,
                                    R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9, R.id.b10, R.id.b11,
                                    R.id.b12, R.id.b13, R.id.b14, R.id.b15, R.id.b16, R.id.b17, R.id.b18,
                                    R.id.b19, R.id.b20, R.id.b21, R.id.b22, R.id.b23, R.id.b24, R.id.b25,
                                    R.id.b26, R.id.b27, R.id.b28, R.id.b29, R.id.b30, R.id.b31, R.id.b32,
                                    R.id.b33, R.id.b34, R.id.b35, R.id.b36, R.id.b37, R.id.b38));

    ArrayList<CategoryCode> categories = new ArrayList<CategoryCode>(Arrays.asList(CHALLENGER_CHAPTER_1, CHALLENGER_CHAPTER_2,
            CHALLENGER_CHAPTER_3, CHALLENGER_CHAPTER_4, CHALLENGER_CHAPTER_5, CHALLENGER_CHAPTER_6, CHALLENGER_CHAPTER_7,
            CHALLENGER_CHAPTER_8, CHALLENGER_CHAPTER_9, CHALLENGER_CHAPTER_10, CHALLENGER_CHAPTER_11, CHALLENGER_CHAPTER_12,
            CHALLENGER_CHAPTER_13, CHALLENGER_CHAPTER_14, CHALLENGER_CHAPTER_15, CHALLENGER_CHAPTER_16, CHALLENGER_CHAPTER_17,
            CHALLENGER_CHAPTER_18, CHALLENGER_CHAPTER_19, CHALLENGER_CHAPTER_20, CHALLENGER_CHAPTER_21, CHALLENGER_CHAPTER_22,
            CHALLENGER_CHAPTER_23, CHALLENGER_CHAPTER_24, CHALLENGER_CHAPTER_25, CHALLENGER_CHAPTER_26, CHALLENGER_CHAPTER_27,
            CHALLENGER_CHAPTER_28, CHALLENGER_CHAPTER_29, CHALLENGER_CHAPTER_30, CHALLENGER_CHAPTER_31, CHALLENGER_CHAPTER_32,
            CHALLENGER_CHAPTER_33, CHALLENGER_CHAPTER_34, CHALLENGER_CHAPTER_35, CHALLENGER_CHAPTER_36, CHALLENGER_CHAPTER_37,
            CHALLENGER_CHAPTER_38));

    ArrayList<String> titles = new ArrayList<String>(Arrays.asList("Challenger - Chapter 1", "Challenger - Chapter 2",
            "Challenger - Chapter 3", "Challenger - Chapter 4", "Challenger - Chapter 5", "Challenger - Chapter 6",
            "Challenger - Chapter 7", "Challenger - Chapter 8", "Challenger - Chapter 9", "Challenger - Chapter 10",
            "Challenger - Chapter 11", "Challenger - Chapter 12", "Challenger - Chapter 13", "Challenger - Chapter 14",
            "Challenger - Chapter 15", "Challenger - Chapter 16", "Challenger - Chapter 17", "Challenger - Chapter 18",
            "Challenger - Chapter 19", "Challenger - Chapter 20", "Challenger - Chapter 21", "Challenger - Chapter 22",
            "Challenger - Chapter 23", "Challenger - Chapter 24", "Challenger - Chapter 25", "Challenger - Chapter 26",
            "Challenger - Chapter 27", "Challenger - Chapter 28", "Challenger - Chapter 29", "Challenger - Chapter 30",
            "Challenger - Chapter 31", "Challenger - Chapter 32", "Challenger - Chapter 33", "Challenger - Chapter 34",
            "Challenger - Chapter 35", "Challenger - Chapter 36", "Challenger - Chapter 37", "Challenger - Chapter 38"));

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenger);

        Intent intent = getIntent();
        if(intent != null) {
            String nnyclass = intent.getStringExtra("nnyclass");
            toast = Toast.makeText(getApplicationContext(), nnyclass, Toast.LENGTH_SHORT);
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
