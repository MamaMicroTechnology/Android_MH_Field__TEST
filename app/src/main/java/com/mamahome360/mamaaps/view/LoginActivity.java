package com.mamahome360.mamaaps.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mamahome360.mamaaps.R;
import com.mamahome360.mamaaps.model.LoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.mamahome360.mamaaps.remote.LoginApiUtils;
import com.mamahome360.mamaaps.remote.UserService;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

Button bt_login;

EditText ed_username,ed_password;

UserService userService;

int[] type ={ConnectivityManager.TYPE_MOBILE,ConnectivityManager.TYPE_WIFI};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        new LoginApiUtils();
        userService = LoginApiUtils.getUserService(getApplicationContext());
        bt_login  = findViewById(R.id.btn_login);
        ed_username = findViewById(R.id.ed_email);
        ed_password = findViewById(R.id.ed_password);
        bt_login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(isNetWorkAvailable(type)){
            String username = ed_username.getText().toString();
            String password = ed_password.getText().toString();
            if(validateLogin(username,password)){
                doLogin(username,password);
            }
        }
        else{
            Toast.makeText(getApplicationContext(),"Internet Connection is Required to Login",Toast.LENGTH_LONG).show();
        }

             }
});
    }


    private boolean isNetWorkAvailable(int[] type){
        try {
            ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            for(int typeNetwork:type){
                assert cm != null;
                NetworkInfo networkInfo = cm.getNetworkInfo(typeNetwork);
                if(networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED){
                    return true;
                }
            }
        }
        catch (Exception e){
            return false;
        }
        return false;
    }

    private boolean validateLogin(String email, String password){
        if(email == null || email.trim().length() == 0){
            Toast.makeText(this,"Please enter your email id",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this,"Please enter your password",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void doLogin(String username,String passowrd){
        Call<LoginModel>  call = userService.login(username,passowrd);

        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.isSuccessful()){
                    LoginModel loginModel = response.body();
                    if(Objects.requireNonNull(loginModel).getMessage().equals("true")){
                           Intent in = new Intent(LoginActivity.this,HomeActivity.class);
                        SharedPreferences pref = getApplicationContext().getSharedPreferences("MH_LE_DATA", MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putBoolean("USER_LOGGED_IN", true);
                        editor.putString("USER_ID", loginModel.getUserid());
                        editor.putString("USER_NAME", loginModel.getUserName());
                        editor.putString("WARD_ASSIGNED", loginModel.getWardAssigned());
                        editor.putString("ORDER_PROJECT_ID", loginModel.getOrderProjectId());
                        editor.putString("SUB_CATEGORY",loginModel.getSubCategory());
                        editor.putString("ORDER_ID",loginModel.getOrderId());
                        editor.putString("LOGISTIC_SUB_WARD",loginModel.getLogisticSubWard());
                        editor.apply();
                        startActivity(in);
                        finish();
                    }
                }
            }
            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),""+t.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        }
    }

