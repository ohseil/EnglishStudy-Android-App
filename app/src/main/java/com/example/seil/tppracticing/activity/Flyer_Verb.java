package com.example.seil.tppracticing.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.seil.tppracticing.R;
import com.example.seil.tppracticing.constantValue.CategoryCode;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_ADMIT;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_AGREE;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_AMUSE;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_ANNOY;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_BELIEVE;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_BLAME;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_CHANGE;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_CHARGE;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_CHECK;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_CLOG;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_COVER;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_DECIDE;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_DENY;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_DEVELOP;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_DIE;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_DO;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_EMBARRASS;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_FINISH;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_FOLLOW;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_GO;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_INVITE;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_LAY;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_LEAVE;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_LIE;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_LIVE;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_LOAD;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_PAY;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_PRAY;
import static com.example.seil.tppracticing.constantValue.CategoryCode.FLYER_VP_TIP;

public class Flyer_Verb extends AppCompatActivity {

    ArrayList<Integer> btnIds = new ArrayList<Integer>(Arrays.asList(R.id.b1, R.id.b2,
            R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9, R.id.b10,
            R.id.b11, R.id.b12, R.id.b13, R.id.b14, R.id.b15, R.id.b16, R.id.b17,
            R.id.b18, R.id.b19, R.id.b20, R.id.b21, R.id.b22, R.id.b23, R.id.b24,
            R.id.b25, R.id.b26, R.id.b27, R.id.b28, R.id.b29));

    ArrayList<CategoryCode> categories = new ArrayList<CategoryCode>(Arrays.asList(FLYER_VP_ADMIT,
            FLYER_VP_AGREE, FLYER_VP_AMUSE, FLYER_VP_ANNOY, FLYER_VP_BELIEVE, FLYER_VP_BLAME,
            FLYER_VP_CHANGE, FLYER_VP_CHARGE, FLYER_VP_CHECK, FLYER_VP_CLOG, FLYER_VP_COVER,
            FLYER_VP_DECIDE, FLYER_VP_DENY, FLYER_VP_DEVELOP, FLYER_VP_DIE, FLYER_VP_DO,
            FLYER_VP_EMBARRASS, FLYER_VP_FINISH, FLYER_VP_FOLLOW, FLYER_VP_GO, FLYER_VP_INVITE,
            FLYER_VP_LAY, FLYER_VP_LEAVE, FLYER_VP_LIE, FLYER_VP_LIVE, FLYER_VP_LOAD, FLYER_VP_PAY,
            FLYER_VP_PRAY, FLYER_VP_TIP));

    ArrayList<String> titles = new ArrayList<String>(Arrays.asList("1강 Admit", "2강 Agree",
            "3강 Amuse", "4강 Annoy,Irritate", "5강 Believe", "6강 Blame", "7강 Change",
            "8강 Charge,Overcharge,Discharge", "9강 Check", "10강 Clog,Coat,Decorate,Pack,Jam,Equip,Furnish",
            "11강 Cover", "12강 Decide", "13강 Deny,Confess", "14강 Develop,Produce", "15강 Die",
            "16강 Do", "17강 Embarrass,Burden,Contaminate,Pollute", "18강 Finish", "19강 Follow",
            "20강 Go", "21강 Invite", "22강 Lay", "23강 Leave", "24강 Lie", "25강 Live",
            "26강 Load", "27강 Pay", "28강 Pray", "29강 Tip"));

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flyer__verb);

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
