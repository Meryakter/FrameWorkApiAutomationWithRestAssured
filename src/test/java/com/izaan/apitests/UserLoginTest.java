package com.izaan.apitests;

import base.Base;
import base.BaseAssertion;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.izaan.api.UserLogin;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

public class UserLoginTest {
    private static ExtentReports extent;
    private static ExtentTest testLog;


    /*Test scenarios
     *
     *1. Postive Test - valid username and valid email
     *2. Negative Test - existing username and email
     * */
    @BeforeMethod
    public void beforeTests() {
        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate User Creation test");

    }

    @AfterMethod
    public void afterMethod() {
        extent.flush();
    }

     @Test
     public void validateUserLogin(){
          Response response= UserLogin.loginUserAPI();
          BaseAssertion.verifyStatusCode(response,200);
          BaseAssertion.verifySpecificMessage(response,"message","Log in successfully!");
      }
    @Test
    public void userLoginErrorPassword() {
        Response response = UserLogin.loginUserNegativePassword();
        BaseAssertion.verifyStatusCode(response, 200);

        BaseAssertion.verifySpecificMessage(response, "message", "Incorrect username or password.");
    }

@Test
    public void invaliduserLoginAPI(){
    Response resp=  UserLogin.loginUserNegativeUsername();
    BaseAssertion.verifySpecificMessage(resp, "statusCode", "400");
    BaseAssertion.verifySpecificMessage(resp,"message","Incorrect username or password.");

}
}

