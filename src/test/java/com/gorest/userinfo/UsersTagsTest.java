package com.gorest.userinfo;

import com.gorest.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UsersTagsTest extends TestBase {

    @WithTags({
            @WithTag("usersfeature:SMOKE"),
            @WithTag("usersfeature:REGRESSION")
    })
    @Title("Provide a 401 status code when incorrect HTTP method is used to access resource")
    @Test
    public void invalidMethod() {
        SerenityRest.rest()
                .given()
                .when()
                .post("/users")
                .then()
                .statusCode(401)
                .log().all();
    }

    @WithTags({
            @WithTag("usersfeature:SANITY"),
            @WithTag("usersfeature:REGRESSION")
    })
    @Title("This test will verify if a status code of 200 is returned for GET request")
    @Test
    public void verifyIfTheStatusCodeIs200() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .log().all();
    }

    @WithTag("usersfeature:REGRESSION")
    @Title("This test will provide an error code of 404 when user tries to access an invalid resource")
    @Test
    public void inCorrectResource() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/users123")
                .then()
                .statusCode(404)
                .log().all();
    }


}
