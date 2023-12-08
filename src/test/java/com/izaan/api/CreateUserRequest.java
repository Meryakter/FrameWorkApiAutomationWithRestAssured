package com.izaan.api;

import base.Base;
import base.GetToken;
import base.PayloadProcessor;
import com.google.gson.Gson;
import io.restassured.response.Response;
import utility.GetCurrentDate;
import utility.URL;

import java.util.Map;
import java.util.Properties;

public class CreateUserRequest {

    static String userId = "Unique"+ GetCurrentDate.getCurrentTimeStamp();

    static String emailAdd = "unique"+GetCurrentDate.getCurrentTimeStamp()+"@gmail.com";
    public static Response createUserAPI(){


        String bearerToken = "Bearer " + GetToken.getToken();

        String url = URL.getEndPoint("/cognito-create-user");

        Properties properties = PayloadProcessor.getValueFromPropertiesFile();

        Map<String, Object> payloadInMap = PayloadProcessor.getProcessedPayloadInJson("CreateUser.json", properties);


        payloadInMap.put("username", CreateUserRequest.userId);
        payloadInMap.put("email", CreateUserRequest.emailAdd);

        String payloadInString = PayloadProcessor.payloadFromMapToString(payloadInMap);

        Response responseBody = Base.POSTRequest(url, payloadInString, bearerToken);

        System.out.println(payloadInString);

        return responseBody;
    }
    public static Response createUserAPINegativeTesting(){


        String bearerToken = "Bearer " + GetToken.getToken();

        String url = URL.getEndPoint("/cognito-create-user");

        Properties properties = PayloadProcessor.getValueFromPropertiesFile();

        Map<String, Object> payloadInMap = PayloadProcessor.getProcessedPayloadInJson("CreateUser.json", properties);

        payloadInMap.put("username", CreateUserRequest.userId);
        payloadInMap.put("email", CreateUserRequest.emailAdd);

        String payloadInString = PayloadProcessor.payloadFromMapToString(payloadInMap);

        Response responseBody = Base.POSTRequest(url, payloadInString, bearerToken);

        System.out.println(payloadInString);

        return responseBody;

    }

}
