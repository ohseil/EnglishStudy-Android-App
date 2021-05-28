package com.example.seil.tppracticing.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.seil.tppracticing.service.DataManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.HashMap;

public abstract class AuthActivity extends AppCompatActivity {

    public static final int RC_SIGN_IN = 1;

    private static GoogleSignInClient mGoogleSignInClient;
    private static GoogleSignInOptions gso;
    private static GoogleSignInAccount account;

    private static String jwtToken;

    public abstract void handleAuthVerifyResult();

    private void setJwtToken(String jwt) { jwtToken = jwt; }
    public static String getJwtToken() { return jwtToken; }

    public void startLogin() {

        /*account = GoogleSignIn.getLastSignedInAccount(this);
        // 기존에 로그인이 되어있다면 바로 다음 프로세스 진행.
        if (account != null) {
            updateUI();
            return;
        }*/

        if (gso == null)
            gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken("919073491758-fe2t234io7anmb07cju1hcg1r96r1jp2.apps.googleusercontent.com")
                    .requestEmail()
                    .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        //mGoogleSignInClient.silentSignIn();
        startActivityForResult(mGoogleSignInClient.getSignInIntent(), RC_SIGN_IN);
    }

    private void updateUI() {

        System.out.println(account.getEmail());
        System.out.println(account.getDisplayName());
        System.out.println(account.getId());
        String token = account.getIdToken();
        System.out.println(token);


        // Server로 token을 보내 인증받아 접근권한에 해당하는 jwt 받기.

        new Thread() {
            public void run() {

                try {

                    RequestBody body = new FormBody.Builder()
                            .add("accessToken", token)
                            .build();

                    OkHttpClient client = new OkHttpClient();

                    Request request = new Request.Builder()
                            .url(DataManager.address + "/v1/signin")
                            .post(body)
                            .build();

                    Response response = client.newCall(request).execute();

                    String tk = response.body().string();
                    System.out.println("response body: " + tk);
                    setJwtToken(tk);
                    handleAuthVerifyResult();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();


        //handleAuthVerifyResult();
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {

        try {
            account = completedTask.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
            updateUI();

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("SignIn", "signInResult:failed code=" + e.getStatusCode());
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
}
