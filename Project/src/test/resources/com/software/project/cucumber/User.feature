@txn
Feature: User
	As an user of the system
	I want to create, delete and manage my account
	
	Scenario: new user
	    Given the system has no user with username "foo"
	    When I create a user with username "foo", password "bar" and e-mail "foo@bar.txn"
	    Then the user is properly stored by the system
	    
	Scenario: user login web
	    Given I am at the Index page
	    When I click on login link
	    And I properly fill the fields with username "admin" and password "admin"
	    And I click the login button
	    Then I'm logged in at the Home page with my "admin" username account
	    
	Scenario: create user account web
		Given I'm at the Sign Up Page
		When I fill the Sign Up form with username "foo", password "bar", password confirmation "bar" and email "foo@bar.txn" 
		And I click the Create account button
		Then a message indicating the user was successfully registered is displayed
		
	Scenario: create user account with existing username
		Given I'm at the Sign Up Page
		When I fill the Sign Up form with username "foo", password "bar", password confirmation "bar" and email "foo@bar.txn"
		And I click the Create account button
		Then a message indicating the username already exists is displayed
	
	Scenario: create user with different passwords
		Given I'm at the Sign Up Page
		When I fill the Sign Up form with username "foo", password "bar1", password confirmation "bar2" and email "foo@bar.txn"
		And I click the Create account button
		Then a message indicating the passwords don't match is displayed
		
	Scenario: create user with invalid email
		Given I'm at the Sign Up Page
		When I fill the Sign Up form with username "foo", password "bar", password confirmation "bar" and email "foo@bar"
		And I click the Create account button
		Then a message indicating the email is not valid
		
			