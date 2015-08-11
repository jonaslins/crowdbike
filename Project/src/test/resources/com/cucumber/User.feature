@User
Feature: User
	As an administrator of the system
	I want to add, edit, search and remove users
	
	Scenario: new user
	    Given the system has no user with username "foo"
	    When I create a user with username "foo" and password "bar"
	    Then the user with username "foo" is properly stored by the system
	
			
			