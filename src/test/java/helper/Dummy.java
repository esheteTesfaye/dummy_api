package helper;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.delete;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Dummy {
	public static final String baseApi = "http://dummy.restapiexample.com/api/v1";

	Dummy() {
		RestAssured.baseURI = baseApi;
	}
}
