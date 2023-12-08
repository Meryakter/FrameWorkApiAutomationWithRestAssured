package com.izaan.api;

import base.Base;
import base.GetToken;
import io.restassured.response.Response;
import utility.URL;


public class UserListRequest {
    public static Response userListRequestAPI() {
       String bearerToken=GetToken.getToken();
       String url=URL.getEndPoint("/cognito-user-list");
       Response response=Base.GETRequest(url,bearerToken);
        return response;
    }
    public static Response getUserListwithInvalidURL()  {
        String url= URL.getEndPoint("/cognito-user-");
        String bearerToken = "Bearer " + GetToken.getToken();
        Response response = Base.GETRequest(url, bearerToken);
        return response;
    }
}

