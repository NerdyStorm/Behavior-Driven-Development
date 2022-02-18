@LoginFeature  @Regression
Feature: Techfios Login functionality validation

    Background: Techfios Login Page
        Given User is on the TechFios Login Page
    @Scenario1
    Scenario: User should be able to login with valid credentials
        When User types username as "demo@techfios.com"
        When User types password as "abc123"
        And User clicks on sign in button
        Then User should be redirected to dashboard page

    @Scenario2
    Scenario: User should not be able to login with invalid password
        When User types username as "demo@techfios.com"
        When User types password as "abc124"
        And User clicks on sign in button
        Then User should not be redirected to dashboard page