package com.gorest.userinfo;

import com.gorest.constants.Endpoints;
import com.gorest.model.PostsPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PostsSteps {

    @Step("Getting all posts")
    public ValidatableResponse getAllPosts() {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 046e36b2cad9cb56822398575d9ae0ef72a77698eb4e0b5e3ec46ccdc39e87ff")
                .when()
                .get(Endpoints.GET_ALL_POST)
                .then();
    }

    @Step
    public ValidatableResponse createPost(int id, int user_id, String title, String body) {
        PostsPojo postsPojo = new PostsPojo();
        postsPojo.setId(id);
        postsPojo.setUser_id(user_id);
        postsPojo.setTitle(title);
        postsPojo.setBody(body);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer a58049a1423e7d9a9d0f744f34e6a883d3f4228d9f8e198bd163aa265bbf5906")
                .body(postsPojo)
                .when()
                .post(Endpoints.CREATE_POST)
                .then();
    }

    @Step
    public ValidatableResponse getPostByID(int postID) {

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer a58049a1423e7d9a9d0f744f34e6a883d3f4228d9f8e198bd163aa265bbf5906")
                .pathParam("postID",postID)
                .when()
                .get(Endpoints.GET_POST_BY_ID)
                .then();
    }

    @Step("Update post with title")
    public ValidatableResponse updatePost(int postId, int id, int user_id, String title, String body) {
        PostsPojo postsPojo = new PostsPojo();
        postsPojo.setId(id);
        postsPojo.setUser_id(user_id);
        postsPojo.setTitle(title);
        postsPojo.setBody(body);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer a58049a1423e7d9a9d0f744f34e6a883d3f4228d9f8e198bd163aa265bbf5906")
                .body(postsPojo)
                .pathParam("postID",postId)
                .when()
                .patch(Endpoints.UPDATE_POST_BY_ID)
                .then();
    }

    @Step
    public ValidatableResponse deletePosts(int userID) {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer a58049a1423e7d9a9d0f744f34e6a883d3f4228d9f8e198bd163aa265bbf5906")
                .pathParam("userID",userID)
                .when()
                .delete(Endpoints.DELETE_POST_BY_ID)
                .then();
    }
}
