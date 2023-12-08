package com.izaan.api;

import base.Base;
import base.GetToken;
import base.PayloadProcessor;
import io.restassured.response.Response;
import utility.GetCurrentDate;
import utility.URL;

import java.util.Map;
import java.util.Properties;

public class UserLogin {


    public static Response loginUserAPI() {


        String bearerToken = "Bearer " + GetToken.getToken();

        String url = URL.getEndPoint("/cognito-login");

        String jsonBody=Base.generatePayLoadString("UserLogin.json");

        Response response = Base.POSTRequest(url,jsonBody, bearerToken);

        return response;
    }


    public static Response loginUserNegativePassword() {


        String bearerToken = "Bearer " + GetToken.getToken();

        String url = URL.getEndPoint("/cognito-login");

        Properties properties = PayloadProcessor.getValueFromPropertiesFile();

        Map<String, Object> payloadInMap = PayloadProcessor.getProcessedPayloadInJson("UserLogin.json", properties);
         String pass="pass";
        payloadInMap.put("username","manager");
        payloadInMap.put("password",pass);

        String payloadInString = PayloadProcessor.payloadFromMapToString(payloadInMap);

        Response responseBody = Base.POSTRequest(url, payloadInString, bearerToken);

        System.out.println(payloadInString);

        return responseBody;
    }
    public static Response loginUserNegativeUsername(){
        String bearerToken = "Bearer " + GetToken.getToken();

        String url = URL.getEndPoint("/cognito-login");

        Properties properties = PayloadProcessor.getValueFromPropertiesFile();

        Map<String, Object> payloadInMap = PayloadProcessor.getProcessedPayloadInJson("UserLogin.json", properties);
        String user="Manager";
        payloadInMap.put("username",user);
        //payloadInMap.put("password","Manager@412");

        String payloadInString = PayloadProcessor.payloadFromMapToString(payloadInMap);

        Response responseBody = Base.POSTRequest(url, payloadInString, bearerToken);

        return responseBody;
    }
    }

