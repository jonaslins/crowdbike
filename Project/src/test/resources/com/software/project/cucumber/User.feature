@txn
Feature: User
	As an administrator of the system
	I want to add, edit, search and remove users
	
	Scenario: new user
	    Given the system has no user with username "foo"
	    When I create a user with username "foo" and password "bar"
	    Then the user is properly stored by the system
	    
	Scenario: user login web
	    Given I am at the Index page
	    When I click on login link
	    And I properly fill the fields with username "admin" and password "admin"
	    And I click the login button
	    Then I'm logged in at the Home page with my "admin" username account
	    
	Scenario: new user account web
		Given I'm at the Sign Up Page
		When I fill the Sign Up form with username "foo", password "bar" and password confirmation "bar" 
		And I click the Create account button
		Then a message indicating the user was successfully registered is displayed
		
			