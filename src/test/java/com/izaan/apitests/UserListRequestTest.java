package com.izaan.apitests;

import base.BaseAssertion;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.izaan.api.UserListRequest;
import io.restassured.response.Response;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

public class UserListRequestTest {
private static ExtentReports extent;
private static ExtentTest testLog;
@BeforeMethod
    public void beforeTests(){
    extent= ReportManager.getInstance();
    testLog=extent.createTest("Validate user creation LIst");
}
@AfterMethod
public void aftreMethod(){
    extent.flush();
}
    @Test
    public  void userListrequestTest(){
        Response response= UserListRequest.userListRequestAPI();
        BaseAssertion.verifyStatusCode(response,200);
        BaseAssertion.verifySpecificMessage(response,"message","User List!");

}
//    @Test (priority = 2,groups = "acceptenceTests")
    @Test
    public void validateUserListWithInvalidURL(){
        Response rs= UserListRequest.getUserListwithInvalidURL();
        BaseAssertion.verifyStatusCode(rs,403);
    }
}
