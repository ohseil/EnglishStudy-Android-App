package com.example.seil.tppracticing.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seil.tppracticing.R;
import com.example.seil.tppracticing.constantValue.CategoryCode;
import com.example.seil.tppracticing.service.MyListManager;
import com.example.seil.tppracticing.entity.EnglishStudyData;
import com.example.seil.tppracticing.service.DataManager;

import java.util.ArrayList;
import java.util.Random;

public class Q_View extends AuthActivity {

    public ArrayList<EnglishStudyData> dataList = new ArrayList<EnglishStudyData>();
    int dataIndex = 0, Rannum, RanCheckNum, RanCheck[];
    Random rn = new Random();
    TextView ch_tv, Qtv, Atv, state_view;
    Toast toast, toast2;
    ImageButton imageB;

    CategoryCode category;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q__view);

        ch_tv = (TextView) findViewById(R.id.ch_tv);
        Qtv = (TextView) findViewById(R.id.Qtv);
        Atv = (TextView) findViewById(R.id.Atv);
        state_view = (TextView) findViewById(R.id.state_view);
        imageB = (ImageButton) findViewById(R.id.imageB);
        toast2 = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

        Intent intent = getIntent();

        if(intent != null) {
            category = (CategoryCode) intent.getSerializableExtra("category");
            title =  intent.getStringExtra("title");

            ch_tv.setText(title);

            getQdata();
        }
    }

    @Override
    public void handleAuthVerifyResult() {
        getQdata();
    }

    public void getQdata() {
        if (title.equals("My List"))
            DataManager.getInstance().ReadByIds(MyListManager.idMap, this);
        else
            DataManager.getInstance().ReadByCategory(category, this);
    }

    public void setInit() {

        RanCheck = new int[dataList.size()];
        RanCheckNum = dataList.size();

        if(dataList.size() == 0) {
            Toast.makeText(getApplicationContext(), "List가 비어있습니다..", Toast.LENGTH_SHORT).show();
            this.finish();
        }
        else {

            toast = Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT);
            toast.show();

            setDataUI();
        }
    }

    public void RA_Clicked(View v) {
        if (Atv.getVisibility() == View.INVISIBLE)
            Atv.setVisibility(View.VISIBLE);
        else
            Atv.setVisibility(View.INVISIBLE);
    }

    // 임의의 문제로 가기 버튼
    public void Random_Clicked(View v) {


        if(RanCheckNum == 0) {
            setCustomToast("  모든 문장을 한번씩 보셨습니다.  ");
            this.finish();
        }

        Rannum = rn.nextInt(dataList.size()) + 0;

        while(RanCheck[Rannum] == 1 && RanCheckNum != 0) {
            Rannum = rn.nextInt(dataList.size()) + 0;
        }

        RanCheck[Rannum] = 1;
        RanCheckNum --;

        dataIndex = Rannum;

        setDataUI();
    }

    // 이전 문제로 가기 버튼
    public void B_Clicked(View v) {

        RanCheckNum = dataList.size();
        for(int i=0; i<dataList.size(); i++)
            RanCheck[i] = 0;

        if (dataIndex != 0) {
            dataIndex--;
            setDataUI();
        }

    }

    // 다음 문제로 가기 버튼
    public void N_Clicked(View v) {

        RanCheckNum = dataList.size();
        for(int i=0; i<dataList.size(); i++)
            RanCheck[i] = 0;

        if (dataIndex + 1 < dataList.size()) {
            dataIndex++;
            setDataUI();
        }

    }

    public void imageClicked(View v) {

        EnglishStudyData data = dataList.get(dataIndex);

        // 즐겨찾기 되어있는 경우
        if (MyListManager.idMap.containsKey(data.getId()) == true) {
            // 로컬 DB에서 즐겨찾기 데이터 삭제
            // id map에서 데이터 삭제
            MyListManager.getInstance(this).deleteToLocalDB(data.getId());
            imageB.setBackgroundResource(R.drawable.empty);

            if (title.equals("My List")) {
                dataList.remove(dataIndex);
                dataIndex = 0;
                setInit();
            }
        }
        else {
            // 로컬 DB에 즐겨찾기 데이터 추가
            // id map에 데이터 추가
            MyListManager.getInstance(this).addToLocalDB(data.getId());
            imageB.setBackgroundResource(R.drawable.full);
        }
        /*
        int count = data.getCount();

        if(data.getString(3).equals("1")) {
            mDbHelper.changeState(data.getString(1), data.getString(2), data.getString(3));
            if(category.equals("My_List"))
                mDbHelper.Delete_List(data.getString(1), data.getString(2), data.getString(4));
            else
                mDbHelper.Delete_List(data.getString(1), data.getString(2), data.getString(3));

            setCustomToast("     즐겨찾기가 취소되었습니다.     ");

            data = mDbHelper.getTestData();

            if(data.getCount() == 0) {
                this.finish();
            }
            else if(data.getCount() < count) {
                this.finish();
            }

            data.move(s);

            imageB.setBackgroundResource(R.drawable.empty);

        } else if(data.getString(3).equals("0")) {
            mDbHelper.changeState(data.getString(1), data.getString(2), data.getString(3));
            mDbHelper.Insert_List(data.getString(1), data.getString(2));

            setCustomToast("     즐겨찾기가 추가되었습니다.     ");

            data = mDbHelper.getTestData();

            if(data.getCount() == 0)
                this.finish();

            data.move(s);

            imageB.setBackgroundResource(R.drawable.full);
        }*/
    }

    public void setDataUI() {

        EnglishStudyData data = dataList.get(dataIndex);

        Qtv.setText(data.getQuestion());
        Atv.setText(data.getAnswer());
        Atv.setVisibility(View.INVISIBLE);

        state_view.setText((dataIndex + 1) + " / " + dataList.size());

        if(title.equals("My List")) {
            ch_tv.setText(CategoryCode.getCategoryStr(Integer.parseInt(data.getCategorycode().toString())).toString().replace("_", " "));
        }

        if (MyListManager.idMap.containsKey(data.getId()) == true)
            imageB.setBackgroundResource(R.drawable.full);
        else
            imageB.setBackgroundResource(R.drawable.empty);

    }

    public  void setCustomToast(String msg){

        //백그라운드 변경
        TextView view = new TextView(getApplicationContext());
        view.setText(msg);
        view.setTextSize(20);
        view.setTextColor(Color.DKGRAY);
        view.setBackgroundColor(Color.argb(190,255,187,0));

        //위치변경
        toast2.setGravity(Gravity.CENTER_HORIZONTAL, 0, 100);
        toast2.setView(view);
        toast2.show();
    }

    @Override
    protected void onPause() {
        if (toast != null)
            toast.cancel();
        if (toast2 != null)
            toast2.cancel();
        super.onPause();
    }

}
