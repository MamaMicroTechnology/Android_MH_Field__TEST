package com.mamahome360.mamaaps.remote;

import android.content.Context;

public class LoginApiUtils {
    public static final String BASE_URL ="https://mamamicrotechnology.com/clients/MH/webapp/api/";
    public static UserService getUserService(Context nContext){
        return com.mamahome360.mamaaps.remote.LoginRetrofitClient.getLoginClient(BASE_URL,nContext).create(UserService.class);
    }
}
