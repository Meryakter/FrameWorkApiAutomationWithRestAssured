package com.izaan.api;

import base.Base;
import base.GetToken;
import base.PayloadProcessor;
import io.restassured.response.Response;
import utility.URL;

import java.util.Map;
import java.util.Properties;

public class SubmitTollRequest {
    public  static Response submitToll(){
        String body= Base.generatePayLoadString("SubmitToll.json");
        String url = URL.getEndPoint("/tollcollection");
        String bearerToken= GetToken.getToken();

        Response response= Base.POSTRequest(url,body,bearerToken);

        System.out.println();

        return response;

    }


}