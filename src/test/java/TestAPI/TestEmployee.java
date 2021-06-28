package TestAPI;

import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import helper.Employee;
import junit.framework.Assert;

public class TestEmployee {
	Employee employee = new Employee();

	@Test
	public void testGetAllEmployees() {
		// validate if able to get all employees as json array
		String resp = employee.getEmployees(HttpStatus.SC_OK);
		JSONObject respObj = new JSONObject(resp);
		JSONArray employees = respObj.getJSONArray("data");
		Assert.assertTrue("zero employee has been returned", employees.length() > 0);
	}

	@Test(dataProvider = "countryNameData")
	public void testGetSpecificEmployee(int id, String name) {
		// get an employee and validate if name is correct
		String resp = employee.getEmployees(id, HttpStatus.SC_OK);

		JSONObject respObj = new JSONObject(resp);
		String actualName = respObj.getJSONObject("data").getString("employee_name");

		// validate name is correct
		Assert.assertTrue("employee name actual = " + actualName + ", expected=" + name, actualName.equals(name));

	}

	@DataProvider
	public Object[][] countryNameData() {
		return new Object[][] { { 1, "Tiger Nixon" }, { 2, "Garrett Winters" } };

	}

	@Test
	public void testDeleteSpecificEmployee() {

		String resp = employee.deleteEmployee(1, HttpStatus.SC_ACCEPTED); // standard delete code is 202
		JSONObject respObj = new JSONObject(resp);
		String expectedMessage = "successfully! deleted Records";
		String actualMessage = respObj.getString("message");
		Assert.assertTrue(actualMessage.equals(expectedMessage));

	}

}
