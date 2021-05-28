package com.example.seil.tppracticing.service;

import android.os.AsyncTask;
import android.widget.Toast;

import com.example.seil.tppracticing.activity.AuthActivity;
import com.example.seil.tppracticing.activity.Q_View;
import com.example.seil.tppracticing.constantValue.CategoryCode;
import com.example.seil.tppracticing.entity.EnglishStudyData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by Seil on 2020-06-11.
 */

public class DataManager {

    private static DataManager dataManager;
    public static final String address = "http://172.30.1.22:10000";

    public static DataManager getInstance() {
        if (dataManager == null)
            return dataManager = new DataManager();
        return dataManager;
    }

    // category별로 데이터 읽기
    public void ReadByCategory(final CategoryCode category, final Q_View activity) {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                try {

                    URL url = new URL(address + "/studydata/byCategory?categoryCode=" + category.ordinal());

                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    con.setRequestProperty("X-AUTH-TOKEN", AuthActivity.getJwtToken());

                    int responseCode = con.getResponseCode();

                    switch(responseCode) {
                        case 400:
                        case 401:
                        case 403:
                        case 500:
                            activity.setCustomToast("Error: " + con.getResponseMessage());
                            activity.finish();
                        case 404:
                            activity.setCustomToast("No Data: " + con.getResponseMessage());
                            activity.finish();
                        case 200: {

                            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                            StringBuilder sb = new StringBuilder();
                            String line;

                            while ((line = br.readLine()) != null) {
                                sb.append(line);
                            }

                            JSONObject jo = new JSONObject(sb.toString());
                            JSONArray jr = new JSONArray(jo.getString("dataList"));

                            for (int i = 0; i < jr.length(); i++) {
                                JSONObject jobj = jr.getJSONObject(i);
                                activity.dataList.add(new EnglishStudyData(jobj.getString("id"),
                                                                        jobj.getString("categorycode"),
                                                                        jobj.getString("question"),
                                                                        jobj.getString("answer")));
                            }

                            activity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    activity.setInit();
                                }
                            });

                            con.disconnect();

                        }

                    }

                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // id 리스트별 데이터 읽기
    public void ReadByIds(final HashMap<Long, Integer> list, final Q_View activity) {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                try {

                    String urlStr = address + "/studydata/byIds?";

                    boolean isFirst = true;
                    for (Long key : list.keySet()) {
                        if (isFirst == true)
                            urlStr += ("ids=" + key);
                        else
                            urlStr += ("&ids=" + key);
                        isFirst = false;
                    }

                    URL url = new URL(urlStr);

                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    con.setRequestProperty("X-AUTH-TOKEN", AuthActivity.getJwtToken());

                    int responseCode = con.getResponseCode();

                    switch(responseCode) {
                        case 400:
                        case 401:
                        case 403:
                        case 500:
                            activity.setCustomToast("Error: " + con.getResponseMessage());
                            activity.finish();
                        case 404:
                            activity.setCustomToast("No Data: " + con.getResponseMessage());
                            activity.finish();
                        case 200: {

                            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                            StringBuilder sb = new StringBuilder();
                            String line;

                            while ((line = br.readLine()) != null) {
                                sb.append(line);
                            }

                            JSONObject jo = new JSONObject(sb.toString());
                            JSONArray jr = new JSONArray(jo.getString("dataList"));

                            for (int i = 0; i < jr.length(); i++) {
                                JSONObject jobj = jr.getJSONObject(i);
                                activity.dataList.add(new EnglishStudyData(jobj.getString("id"),
                                        jobj.getString("categorycode"),
                                        jobj.getString("question"),
                                        jobj.getString("answer")));
                            }

                            activity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    activity.setInit();
                                }
                            });

                            con.disconnect();

                        }

                    }

                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
