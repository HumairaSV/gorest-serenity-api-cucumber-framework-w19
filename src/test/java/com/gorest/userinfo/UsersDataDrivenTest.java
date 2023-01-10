package com.gorest.userinfo;

import com.gorest.testbase.TestBase;
import com.gorest.utils.PropertyReader;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@Concurrent(threads = "2x")
@UseTestDataFrom("src/test/java/resources/testdata/usersdata.csv")
@RunWith(SerenityParameterizedRunner.class)
public class UsersDataDrivenTest extends TestBase {

        private String name;
        private String email;
        private String gender;
        private String status;
        static String  token = PropertyReader.getInstance().getProperty("token");

    @Steps
    UsersSteps usersSteps;
    @Title("Data driven test for adding multiple users to the application")
    @Test
    public void createMultipleUsers(){
        usersSteps.createUser(name,gender,email,status,token).statusCode(201);
    }
}
