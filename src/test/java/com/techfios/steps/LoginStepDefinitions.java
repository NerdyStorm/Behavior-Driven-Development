package com.techfios.steps;

import java.util.LinkedHashMap;

import com.techfios.pages.DatabasePage;
import com.techfios.pages.LoginPage;
import com.techfios.util.BrowserFactory;


import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinitions extends BrowserFactory{
    private String url = "https://www.techfios.com/billing/?ng=login";
    private WebDriver driver;
    private DatabasePage databasePage;
    private String username;
    private String password;

    LoginPage loginPage;
    @Before
    public void initialize(){
        driver = init();
        loginPage = new LoginPage(driver);
        databasePage = new DatabasePage();

        
        LinkedHashMap<Integer, String[]> loginInfoMap = databasePage.getData();

        username = loginInfoMap.get(2)[0];
        password = loginInfoMap.get(1)[1];

        // //Custom function that reads the String data and divides it up based on the spaces present
        // String loginInfo = databasePage.getData();

        // char[] c = loginInfo.toCharArray();
        // int arrayCounter = 0;
        // System.out.println(c.length-1);
        // int i = 0;
        // String value = "";
        // String[] values = new String[100];
        // for (char p: c ){
        //     arrayCounter++;
        //     System.out.println("ac: " + arrayCounter);
 
        //  if (arrayCounter == c.length){
        //  System.out.println("at the end of array!");
        //  value +=p;
        //  values[i] = value;
        //  }
        //  else if (p != ' '){
        //      value += p;
        //  }
        //  else if (p == ' ') {
        //      values[i] = value;
        //      value = "";
        //      i++;
        //  }
        //  username = values[0];
        //  password = values[1];
         
        // //System.out.println("--Login parameters--\n" + "u:" + values[0] + "\n" + "p:" + values[1]);
        // }

        
    }
    @Given("^User is on the TechFios Login Page$")
    public void user_is_on_the_TechFios_Login_Page() throws Throwable {
        driver.get(url);
    }

    @When ("^User enters \"([^\"]*)\" from techfios database$")
    public void User_enters_data_from_techfios_database (String data){
        if (data.equalsIgnoreCase("username")){
            loginPage.typeUsername(username);
        }
        else if (data.equalsIgnoreCase("password")){
            loginPage.typePassword(password);
        }
    }

    // @When ("^User enters username from techfios database$")
    // public void User_enters_username_from_techfios_database(){
    //     loginPage.typeUsername(username);
    // }

    // @When ("^User enters password from techfios database$")
    // public void User_enters_password_from_techfios_database(){
    //     loginPage.typePassword(password);
    // }

    @When("^User types username as \"([^\"]*)\"$")
    public void user_types_username_as(String arg1) throws Throwable {
        loginPage.typeUsername(arg1);
    }

    @When("^User types password as \"([^\"]*)\"$")
    public void user_types_password_as(String arg1) throws Throwable {
        loginPage.typePassword(arg1);
    }

    @When("^User clicks on sign in button$")
    public void user_clicks_on_sign_in_button() throws Throwable {
        loginPage.submit();
    }

    @Then("^User should be redirected to dashboard page$")
    public void user_should_be_redirected_to_dashboard_page() throws Throwable {
        loginPage.AssertDashboardPage();
    }
    @Then ("^User should not be redirected to dashboard page$")
    public void User_should_not_be_redirected_to_dashboard_page(){
        loginPage.AssertNotDashboardPage();
    }

}
