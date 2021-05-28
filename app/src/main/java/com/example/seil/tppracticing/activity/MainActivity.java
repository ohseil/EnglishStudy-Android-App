package com.example.seil.tppracticing.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.seil.tppracticing.R;
import com.example.seil.tppracticing.service.DataManager;
import com.example.seil.tppracticing.service.MyListManager;
import com.example.seil.tppracticing.db.TestAdapter;

import java.io.FileInputStream;
import java.util.Properties;

public class MainActivity extends AuthActivity {

    public static Properties props;

    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*try {
            // 프로퍼티 파일 위치
            String propFile = "C:/Users/Seil/Downloads/AndroidStudioProjects/TPPracticing/config.properties";
            // 프로퍼티 객체 생성
            props = new Properties();
            // 프로퍼티 파일 스트림에 담기
            FileInputStream fis = new FileInputStream(propFile);
            // 프로퍼티 파일 로딩
            props.load(new java.io.BufferedInputStream(fis));

            System.out.println(props.getProperty("address"));

        }catch(Exception e){
            e.printStackTrace();
        }*/

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
       TestAdapter mDbHelper = new TestAdapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        MyListManager.getInstance(this).getFromLocalDB();

        //startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        startLogin();
    }

    @Override
    public void handleAuthVerifyResult() {
        Toast.makeText(getApplicationContext(), "Sign in.", Toast.LENGTH_SHORT).show();
    }

    public void b1_Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), Beginner.class);
        intent.putExtra("nnyclass", "Beginner");
        startActivityForResult(intent, 1001);
    }

    public void b2_Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), Challenger.class);
        intent.putExtra("nnyclass", "Challenger");
        startActivityForResult(intent, 1002);
    }

    public void b3_Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), Sub_Flyer.class);
        intent.putExtra("nnyclass", "Flyer");
        startActivityForResult(intent, 1003);
    }

    public void b4_Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), Q_View.class);
        intent.putExtra("title", "My List");
        startActivityForResult(intent, 1004);
    }

    /*public void b5_Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), Business.class);
        intent.putExtra("nnyclass", "Business");
        startActivityForResult(intent, 1005);
    }*/

}
