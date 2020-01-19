package com.githubwebhook.bdd.stepdef

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import io.restassured.response.Response


class IssueSteps {
    private lateinit var path: String
    private lateinit var response: Response

    @Given("^Set Api$")
    @Throws(Throwable::class)
    fun set_api() {
        path = "http://localhost:8080"
    }

    @When("^I POST to \"([^\"]*)\" with json$")
    @Throws(Throwable::class)
    fun i_post_to_something_with_json(endPoint: String?, payload: String) {
        response = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post(path + endPoint)
                .then()
                .extract()
                .response()

    }

    @Then("^Status code should be \"([^\"]*)\"$")
    @Throws(Throwable::class)
    fun status_code_should_be_something(statusCode: Int) {
        response.then().statusCode(statusCode)
    }

    @When("^I GET from \"([^\"]*)\"$")
    @Throws(Throwable::class)
    fun i_get_from_something(endPoint: String?) {

        response = given()
                .contentType(ContentType.JSON)
                .get(endPoint)
                .then()
                .extract()
                .response()

    }


}


