package com.izaan.apitests;

import base.BaseAssertion;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.izaan.api.CreateUserRequest;
import com.izaan.api.SubmitTollRequest;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

public class SubmitTollRequestTest {
    private static ExtentReports extent;
    private static ExtentTest testLog;
    @BeforeMethod
    public void beforeTests(){
        extent=ReportManager.getInstance();
        testLog=extent.createTest("Validate User creation test");
        }
        @AfterMethod
        public void afterMethod(){
        extent.flush();
        }
    @Test
    public void submitTollTest() {
        Response response = SubmitTollRequest.submitToll();
        BaseAssertion.verifyStatusCode(response, 200);
        BaseAssertion.verifySpecificMessage(response, "message", "success");



    }}