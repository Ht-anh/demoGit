#Author: your.email@your.domain.com
@loginFeature
Feature: login
  Test the login functionlity of the web application
  Background: 
    Given I am on the Home page
    When I navigate to the sign in page
  @Invalid
  Scenario: login with wrong password
    When I enter the email as 'abctest@test.com' and password as 'invalidPass'
    And I click Sign in button
    Then I should see the message: 'Authentication failed.'
	@Invalid
	Scenario: login with wrong email
    When I enter the email as 'abctest1@test.com' and password as '123456'
    And I click Sign in button
    Then I should see the message: 'Authentication failed.'
  @Valid
  Scenario: login successfully
    When I enter the email as 'abctest@test.com' and password as '123456'
    And I click Sign in button
    Then I should see the My Account page
