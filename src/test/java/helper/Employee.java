package helper;

import static io.restassured.RestAssured.get;

import org.apache.http.HttpStatus;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Employee {
	Dummy dummy = new Dummy();

	public String getEmployees(int status_code) {

		Response resp = get("/employees");

		int statusCode = resp.statusCode();
		Assert.assertTrue("unable to find all employees", statusCode == status_code);
		return resp.asString();

	}

	public String getEmployees(int id, int status_code) {
		Response resp = get("/employee/" + id);
		int statusCode = resp.statusCode();
		Assert.assertTrue("unable to find employee with employee_id = " + id, statusCode == status_code); // 200
		return resp.asString();

	}

	public String deleteEmployee(int id, int status_code) {
		Response resp = get("/delete/" + id);
		int statusCode = resp.statusCode();
		Assert.assertTrue("unable to delete employee with employee_id = " + id, statusCode == status_code); // 200
		return resp.asString();

	}

}
