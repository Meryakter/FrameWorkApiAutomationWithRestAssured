package com.izaan.apitests;

import base.BaseAssertion;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.izaan.api.GetListOfTollsCollectionPointId;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

public class GetListTollsCollectionPointTest {
    private static ExtentReports extent;
    private static ExtentTest testLog;

    @BeforeMethod
    public void beforeTest() {
        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate user creation list");
    }

    @AfterMethod
    public void afterMethod() {
        extent.flush();
    }

    @Test
    public void getListTollsCollectionPointTest() {
        Response response = GetListOfTollsCollectionPointId.getListOfTollsCollectionPointId();
        BaseAssertion.verifySpecificMessage(response, "message", "success");
    }

    @Test
    public void getListTollsCollectionPointNegativeTest() {
        Response response = GetListOfTollsCollectionPointId.getListOfCollectionPointNegativeIdAPI();
        BaseAssertion.verifyStatusCode(response, 200);
        BaseAssertion.verifySpecificMessage(response, "message", "success");
    }



    }

