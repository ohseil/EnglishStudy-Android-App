package com.example.seil.tppracticing.activity;

import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.seil.tppracticing.R;
import com.example.seil.tppracticing.constantValue.CategoryCode;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_11;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_12;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_13;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_14;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_15;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_16;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_17;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_18;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_19;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_2;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_21;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_22;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_23;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_24;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_25;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_26;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_27;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_28;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_3;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_4;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_5;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_6;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_7;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_8;
import static com.example.seil.tppracticing.constantValue.CategoryCode.BEGINNER_CHAPTER_9;

public class Beginner extends AppCompatActivity {

    ArrayList<Integer> btnIds = new ArrayList<Integer>(Arrays.asList(R.id.b2, R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9,
                R.id.b11, R.id.b12, R.id.b13, R.id.b14, R.id.b15, R.id.b16, R.id.b17,
                R.id.b18, R.id.b19, R.id.b21, R.id.b22, R.id.b23, R.id.b24, R.id.b25,
                R.id.b26, R.id.b27, R.id.b28));

    ArrayList<CategoryCode> categories = new ArrayList<CategoryCode>(Arrays.asList(BEGINNER_CHAPTER_2, BEGINNER_CHAPTER_3, BEGINNER_CHAPTER_4, BEGINNER_CHAPTER_5,
                                BEGINNER_CHAPTER_6, BEGINNER_CHAPTER_7, BEGINNER_CHAPTER_8, BEGINNER_CHAPTER_9,
                                BEGINNER_CHAPTER_11, BEGINNER_CHAPTER_12, BEGINNER_CHAPTER_13, BEGINNER_CHAPTER_14,
                                BEGINNER_CHAPTER_15, BEGINNER_CHAPTER_16, BEGINNER_CHAPTER_17, BEGINNER_CHAPTER_18,
                                BEGINNER_CHAPTER_19, BEGINNER_CHAPTER_21, BEGINNER_CHAPTER_22, BEGINNER_CHAPTER_23,
                                BEGINNER_CHAPTER_24, BEGINNER_CHAPTER_25, BEGINNER_CHAPTER_26, BEGINNER_CHAPTER_27,
                                BEGINNER_CHAPTER_28));

    ArrayList<String> titles = new ArrayList<String>(Arrays.asList("Beginner - Chapter 2", "Beginner - Chapter 3", "Beginner - Chapter 4", "Beginner - Chapter 5",
            "Beginner - Chapter 6", "Beginner - Chapter 7", "Beginner - Chapter 8", "Beginner - Chapter 9",
            "Beginner - Chapter 11", "Beginner - Chapter 12", "Beginner - Chapter 13", "Beginner - Chapter 14",
            "Beginner - Chapter 15","Beginner - Chapter 16","Beginner - Chapter 17","Beginner - Chapter 18",
            "Beginner - Chapter 19","Beginner - Chapter 21","Beginner - Chapter 22","Beginner - Chapter 23",
            "Beginner - Chapter 24","Beginner - Chapter 25","Beginner - Chapter 26","Beginner - Chapter 27","Beginner - Chapter 28"));

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);

        Intent intent = getIntent();
        if(intent != null) {
            String nnyclass = intent.getStringExtra("nnyclass");
            toast = Toast.makeText(getApplicationContext(), nnyclass, Toast.LENGTH_SHORT);
            toast.show();
        }

        NestedScrollView scrollView = (NestedScrollView) findViewById(R.id.nestedscroll);
        scrollView.requestFocus(View.FOCUS_UP);
        scrollView.scrollTo(0,0);

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
