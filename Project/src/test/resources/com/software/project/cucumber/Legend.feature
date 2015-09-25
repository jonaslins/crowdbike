@txn
Feature: Legend
	As an administrator of the system
	I want to create, delete and manage the map legends
	So I can provide legends for common users
	
	Scenario: new legend
	    Given the system has no legend with name "foo"
	    When I create a legend with name "foo"
	    Then the legend is stored by the system
	    
    Scenario: new legend with existing name
	    Given the system has a legend with name "foo1"
	    When I create a legend with name "foo1"
	    Then the legend with name "foo1" is not stored in the system
	    
	Scenario: new legend web
	    Given I am at the Admin Page
	    When I click the add legend button
	    And I fill the name field with "foo2"
	    And I click the create legend button
	    Then a message indicating the legend was successfully stored is displayed
	    
	Scenario: delete legend
	    Given the system has a legend with name "foo3"
	    When I try to delete a legend with name "foo3"
	    Then the legend with name "foo3" is not stored in the system
	 
