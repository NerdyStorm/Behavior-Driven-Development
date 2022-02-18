Feature: Login to TechFios Website with information from Database

    @DbScenario
    Scenario: Login to Techfios with correct credentials from database;
        Given User is on the TechFios Login Page
        When User enters "username" from techfios database
        When User enters "password" from techfios database
        And User clicks on sign in button
        Then User should not be redirected to dashboard page
