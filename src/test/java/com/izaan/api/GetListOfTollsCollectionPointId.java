package com.izaan.api;


import base.Base;
import base.GetToken;
import io.restassured.response.Response;
import utility.URL;
import base.BaseAssertion;

public class GetListOfTollsCollectionPointId {
    public static Response getListOfTollsCollectionPointId(){
        String bearerToken = "Bearer " + GetToken.getToken();

        String url = URL.getEndPoint("/toll-collection-list");
        String key="collectionPointId";
        String Value="NY088734";
        Response response= Base.GETRequest(url,bearerToken,key,Value);
        return response;

    }

    public static Response getListOfCollectionPointNegativeIdAPI() {

        String bearerToken = "Bearer " + GetToken.getToken();

        String url = URL.getEndPoint("/toll-collection-list");
        String key = "collectionPointId";
        String Value = "CY088734";
        Response response = Base.GETRequest(url, bearerToken, key, Value);
            return response;

        }


    }



