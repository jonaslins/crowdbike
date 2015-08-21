@txn
Feature: User
	As an administrator of the system
	I want to add, edit, search and remove users
	
	Scenario: new user
	    Given the system has no user with username "fooo"
	    When I create a user with username "fooo" and password "bar"
	    Then the user is properly stored by the system
	    
	Scenario: user login web
		Given I have an account with username "admin" and password "admin" 
	    And I am at the Index page
	    When I click on login link
	    And I properly fill the fields with username "admin" and password "admin"
	    And click the login button
	    Then I'm logged in at the Home page with my "admin" username account
	
			
			