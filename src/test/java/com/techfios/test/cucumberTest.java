package com.techfios.test;

import com.techfios.pages.LoginPage;
import com.techfios.util.BrowserFactory;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class cucumberTest {
    RemoteWebDriver driver;

    private String username = "demo@techfios.com";
    private String password = "abc123";


    public void test(){
        //System.out.println((new ChromeDriver()).getClass());
        driver = (RemoteWebDriver) (new BrowserFactory()).init();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

    }
    
}
